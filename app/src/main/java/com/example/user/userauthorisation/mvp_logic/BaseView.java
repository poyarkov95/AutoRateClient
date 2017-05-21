package com.example.user.userauthorisation.mvp_logic;

import android.support.annotation.StringRes;

public interface BaseView<T> {
    void setPresenter(T presenter);

    void makeToast(@StringRes int stringId);

    void makeToast(String message);
}
