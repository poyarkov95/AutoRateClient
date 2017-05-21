package com.example.user.userauthorisation.autoservice_detail_activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.util.ActivityUtils;

public class AutoServiceDetailActivity extends AppCompatActivity {

    private static final String AUTO_SERVICE_DETAIL_FRAGMENT = "AUTO_SERVICE_DETAIL_FRAGMENT";
    public static final String EXTRA_AUTO_SERVICE_NAME = "autoServiceName";

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_service_detail);

        fragmentManager = getFragmentManager();
        AutoServiceDetailFragment autoServiceDetailFragment = (AutoServiceDetailFragment) fragmentManager.findFragmentByTag(AUTO_SERVICE_DETAIL_FRAGMENT);

        if(autoServiceDetailFragment == null){
            autoServiceDetailFragment = AutoServiceDetailFragment.getInstance();
        }

        ActivityUtils.addFragmentToActivity(fragmentManager,
                autoServiceDetailFragment,
                R.id.activity_auto_service_detail,
                AUTO_SERVICE_DETAIL_FRAGMENT);

    }
}
