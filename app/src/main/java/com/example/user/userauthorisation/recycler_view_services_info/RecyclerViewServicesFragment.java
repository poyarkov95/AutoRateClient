package com.example.user.userauthorisation.recycler_view_services_info;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.model.Service;

import java.util.List;

import static com.example.user.userauthorisation.recycler_view_services_info.RecyclerViewServicesInfoActivity.EXTRA_AUTO_SERVICE_ID;
import static com.example.user.userauthorisation.recycler_view_services_info.RecyclerViewServicesInfoActivity.EXTRA_AUTO_SERVICE_NAME;
import static com.example.user.userauthorisation.recycler_view_services_info.RecyclerViewServicesInfoActivity.EXTRA_FLAG_FOR_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewServicesFragment extends Fragment implements RecyclerViewServicesInfoContract.View {
    private RecyclerViewServicesInfoContract.Presenter presenter;
    private DataAdapter dataAdapter;

    public RecyclerViewServicesFragment() {
        // Required empty public constructor
    }

    public static RecyclerViewServicesFragment getInstance(){
        return new RecyclerViewServicesFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null){
            presenter = new RecyclerViewServicesInfoPresenter(this);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Long autoServiceId = (Long)getActivity().getIntent().getExtras().get(EXTRA_AUTO_SERVICE_ID);
        String flag = (String)getActivity().getIntent().getExtras().get(EXTRA_FLAG_FOR_SERVICE);
        presenter.getObjectsForRecyclerView(autoServiceId, flag);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view_services, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.activity_recycler_view_services_info);
        dataAdapter = new DataAdapter();
        recyclerView.setAdapter(dataAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void setPresenter(RecyclerViewServicesInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setServicesListOnAdapter(Service[] autoServices) {
        dataAdapter.setAutoServices(autoServices);
        dataAdapter.notifyDataSetChanged();
    }
}
