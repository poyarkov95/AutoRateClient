package com.example.user.userauthorisation.afterloginlogic;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.util.ActivityUtils;

public class AfterLoginActivity extends AppCompatActivity {

    private static final String AFTER_LOGIN_FRAGMENT = "AFTER_LOGIN_FRAGMENT";

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        fragmentManager = getFragmentManager();

        AfterLoginLogicFragment afterLoginLogicFragment = (AfterLoginLogicFragment)fragmentManager.findFragmentByTag(AFTER_LOGIN_FRAGMENT);

        if(afterLoginLogicFragment == null){
            afterLoginLogicFragment = AfterLoginLogicFragment.getInstance();

        }

        ActivityUtils.addFragmentToActivity(fragmentManager,
                afterLoginLogicFragment,
                R.id.activity_after_login,
                AFTER_LOGIN_FRAGMENT);

    }
}
