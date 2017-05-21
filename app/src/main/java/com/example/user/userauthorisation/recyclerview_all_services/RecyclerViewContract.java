package com.example.user.userauthorisation.recyclerview_all_services;

import android.app.Activity;

import com.example.user.userauthorisation.model.AutoService;
import com.example.user.userauthorisation.mvp_logic.BasePresenter;
import com.example.user.userauthorisation.mvp_logic.BaseView;

/**
 * Created by User on 27.04.2017.
 */

public interface RecyclerViewContract {

    interface View extends BaseView<Presenter> {

        void setPresenter(RecyclerViewContract.Presenter presenter);

        void setAutoServiceListOnAdapter(AutoService[] autoServices);
    }

    interface Presenter extends BasePresenter {
        void onRecyclerViewItemClicked(String autoServiceName, Activity activity);
    }

}
