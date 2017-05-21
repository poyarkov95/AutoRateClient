package com.example.user.userauthorisation.afterloginlogic;

public class AfterLoginLogicPresenter implements AfterLoginContract.Presenter{

    private AfterLoginContract.View view;

    public AfterLoginLogicPresenter(AfterLoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onShowContactsClick() {

    }

    @Override
    public void onShowAutoServicesClicked() {
        view.startAutoServicesRecyclerViewActivity();
    }
}
