package com.example.user.userauthorisation.login;

import com.example.user.userauthorisation.mvp_logic.BasePresenter;
import com.example.user.userauthorisation.mvp_logic.BaseView;

public interface LoginPageContract {
    interface View extends BaseView<Presenter> {
        String getUserName();

        String getPassword();

        void startAfterLoginActivity();

        void startCreateAccountActivity();

        void setPresenter(LoginPageContract.Presenter presenter);


    }

    interface Presenter extends BasePresenter {
        void onLoginClicked();

        void onRegisterClicked();
    }
}

