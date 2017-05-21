package com.example.user.userauthorisation.recyclerview_all_services;

import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.util.ActivityUtils;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String RECYCLER_VIEW_FRAGMENT = "RECYCLER_VIEW_FRAGMENT";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        fragmentManager = getFragmentManager();

        RecyclerViewFragment recyclerViewFragment = (RecyclerViewFragment)fragmentManager.findFragmentByTag(RECYCLER_VIEW_FRAGMENT);

        if(recyclerViewFragment == null){
            recyclerViewFragment = RecyclerViewFragment.getInstance();
        }

        ActivityUtils.addFragmentToActivity(fragmentManager,
                recyclerViewFragment,
                R.id.activity_recycler_view,
                RECYCLER_VIEW_FRAGMENT);
    }
}
