package com.example.user.userauthorisation.createaccount;

import android.support.annotation.StringRes;

import com.example.user.userauthorisation.mvp_logic.BasePresenter;
import com.example.user.userauthorisation.mvp_logic.BaseView;

public interface CreateAccountContract {
    interface View extends BaseView<Presenter>{

        String getPassword();

        String getPasswordConfirmation();

        String getUserName();

        void startLoginActivity();

        void startAfterLoginActivity();

        void setPresenter(CreateAccountContract.Presenter presenter);

    }

    interface Presenter extends BasePresenter{
        void onCreateAccountClick();
    }
}
