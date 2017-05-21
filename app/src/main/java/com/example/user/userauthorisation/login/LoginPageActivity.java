package com.example.user.userauthorisation.login;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.createaccount.CreateAccountFragment;
import com.example.user.userauthorisation.util.ActivityUtils;

public class LoginPageActivity extends AppCompatActivity {

    private static final String LOGIN_FRAGMENT = "LOGIN_FRAGMENT";


    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getFragmentManager();
        LoginPageFragment loginPageFragment = (LoginPageFragment)fragmentManager.findFragmentByTag(LOGIN_FRAGMENT);


        if(loginPageFragment == null){
            loginPageFragment = LoginPageFragment.getInstance();
        }

        ActivityUtils.addFragmentToActivity(fragmentManager,
                loginPageFragment,
                R.id.activity_login,
                LOGIN_FRAGMENT
        );
    }
}
