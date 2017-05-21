package com.example.user.userauthorisation.recycler_view_services_info;


import com.example.user.userauthorisation.model.Service;
import com.example.user.userauthorisation.mvp_logic.BasePresenter;

import java.util.List;

public interface RecyclerViewServicesInfoContract {
    interface View {
        void setPresenter(RecyclerViewServicesInfoContract.Presenter presenter);

        void setServicesListOnAdapter(Service[] autoServices);
    }

    interface Presenter extends BasePresenter {
        void getObjectsForRecyclerView(Long autoServiceName, String flag);
    }
}
