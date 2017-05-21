package com.example.user.userauthorisation.afterloginlogic;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.contuctus.ContactUsActivity;
import com.example.user.userauthorisation.recyclerview_all_services.RecyclerViewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AfterLoginLogicFragment extends Fragment implements AfterLoginContract.View {

    private ImageView autoRateImageView;
    private Button showAllAutoServicesButton;
    private Button contactUsButton;

    private AfterLoginContract.Presenter presenter;


    public AfterLoginLogicFragment() {
        // Required empty public constructor
    }

    public static AfterLoginLogicFragment getInstance(){
        return new AfterLoginLogicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_after_login_logic, container, false);
        autoRateImageView = (ImageView) view.findViewById(R.id.after_login_fragment_image_view);
        autoRateImageView.setImageDrawable(getResources().getDrawable(R.drawable.label));
        showAllAutoServicesButton = (Button)view.findViewById(R.id.show_all_auto_services_button);
        contactUsButton = (Button)view.findViewById(R.id.contact_us_button);

        showAllAutoServicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onShowAutoServicesClicked();
            }
        });

        contactUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onShowContactsClick();
            }
        });

        return  view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null){
            presenter = new AfterLoginLogicPresenter(this);
        }
    }

    @Override
    public void startAutoServicesRecyclerViewActivity() {
        Intent intent = new Intent(getActivity(), RecyclerViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void startContactUsActivity() {
        Intent intent = new Intent(getActivity(), ContactUsActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(AfterLoginContract.Presenter presenter) {
            this.presenter = presenter;
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
