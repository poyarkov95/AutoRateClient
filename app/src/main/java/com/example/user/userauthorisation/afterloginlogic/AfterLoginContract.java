package com.example.user.userauthorisation.afterloginlogic;

import com.example.user.userauthorisation.mvp_logic.BasePresenter;
import com.example.user.userauthorisation.mvp_logic.BaseView;

/**
 * Created by User on 19.03.2017.
 */

public interface AfterLoginContract {
    interface View extends BaseView<Presenter>{
        void startAutoServicesRecyclerViewActivity();

        void startContactUsActivity();

        void setPresenter(AfterLoginContract.Presenter presenter);
    }

    interface Presenter extends BasePresenter{
        void onShowContactsClick();

        void onShowAutoServicesClicked();
    }
}
