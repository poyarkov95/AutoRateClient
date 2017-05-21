package com.example.user.userauthorisation.createaccount;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.util.ActivityUtils;

public class CreateAccountActivity extends AppCompatActivity {

    private static final String CREATE_FRAGMENT = "CREATE_FRAGMENT";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        fragmentManager = getFragmentManager();

        CreateAccountFragment createAccountFragment = (CreateAccountFragment)fragmentManager.findFragmentByTag(CREATE_FRAGMENT);

        if(createAccountFragment == null){
            createAccountFragment = CreateAccountFragment.getInstance();
        }

        ActivityUtils.addFragmentToActivity(fragmentManager,
                createAccountFragment,
                R.id.activity_create_account,
                CREATE_FRAGMENT
        );
    }
}
