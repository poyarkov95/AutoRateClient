package com.example.user.userauthorisation.recyclerview_all_services;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.model.AutoService;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements RecyclerViewContract.View{

    private RecyclerViewContract.Presenter presenter;
    private DataAdapter dataAdapter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null){
            presenter = new RecyclerViewPresenter(this);
        }
    }

    public static RecyclerViewFragment getInstance(){
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        dataAdapter = new DataAdapter(getActivity());
        recyclerView.setAdapter(dataAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());//getContext() better
        recyclerView.setLayoutManager(layoutManager);

        dataAdapter.setListener(new DataAdapter.Listener() {
            @Override
            public void onClick(String autoServiceName) {
                presenter.onRecyclerViewItemClicked(autoServiceName, getActivity());
            }
        });
        return view;
    }

    @Override
    public void setPresenter(RecyclerViewContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setAutoServiceListOnAdapter(AutoService[] autoServices) {
        dataAdapter.setAutoServices(autoServices);
        dataAdapter.notifyDataSetChanged();
    }

    @Override
    public void makeToast(@StringRes int stringId) {
        Toast.makeText(getActivity().getApplicationContext(), getString(stringId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
