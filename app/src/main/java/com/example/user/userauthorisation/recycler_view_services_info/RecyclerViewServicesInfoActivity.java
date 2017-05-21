package com.example.user.userauthorisation.recycler_view_services_info;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.util.ActivityUtils;

public class RecyclerViewServicesInfoActivity extends AppCompatActivity {
    private static final String RECYCLER_VIEW_SERVICES_INFO_FRAGMENT = "RECYCLER_VIEW_SERVICES_INFO_FRAGMENT";
    public static final String EXTRA_AUTO_SERVICE_NAME = "autoServiceName";
    public static final String EXTRA_AUTO_SERVICE_ID = "autoServiceId";
    public static final String EXTRA_FLAG_FOR_SERVICE = "extraFlag";

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_services_info);

        fragmentManager = getFragmentManager();

        RecyclerViewServicesFragment recyclerViewServicesFragment = (RecyclerViewServicesFragment) fragmentManager.findFragmentByTag(RECYCLER_VIEW_SERVICES_INFO_FRAGMENT);
        if (recyclerViewServicesFragment == null) {
            recyclerViewServicesFragment = RecyclerViewServicesFragment.getInstance();
        }

        ActivityUtils.addFragmentToActivity(fragmentManager,
                recyclerViewServicesFragment,
                R.id.activity_recycler_view_services_info,
                RECYCLER_VIEW_SERVICES_INFO_FRAGMENT);
    }
}
