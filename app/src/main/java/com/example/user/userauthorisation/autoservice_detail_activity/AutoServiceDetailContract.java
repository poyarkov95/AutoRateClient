package com.example.user.userauthorisation.autoservice_detail_activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.user.userauthorisation.model.Service;
import com.example.user.userauthorisation.mvp_logic.BasePresenter;
import com.example.user.userauthorisation.mvp_logic.BaseView;
import com.example.user.userauthorisation.util.ActivityUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 29.04.2017.
 */

public interface AutoServiceDetailContract {
    interface View extends BaseView<Presenter>{
        void setPresenter(AutoServiceDetailContract.Presenter presenter);
        void setAutoServiceName(String autoServiceName);
        void askForCallPermission();
        ImageView getImageView();
        void addDataToSpinnerAdapter(Set<String> services);
    }

    interface Presenter extends BasePresenter{
        void getAutoServiceNameAndImage(String autoServiceName);

        void onLookAtMapClicked();
        void onGoToWebPageClicked();
        void onMakeCallClicked();
        void onShowAllServicesClicked(Activity activity);
        void processSelectedSpinnerItem(Activity activity, String serviceCategory);
    }
}
