package com.example.user.userauthorisation.autoservice_detail_activity;


import android.Manifest;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.model.Service;
import com.example.user.userauthorisation.remote_logic.Constants;

import java.util.List;
import java.util.Set;

import static com.example.user.userauthorisation.autoservice_detail_activity.AutoServiceDetailActivity.EXTRA_AUTO_SERVICE_NAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoServiceDetailFragment extends Fragment implements AutoServiceDetailContract.View {
    //TODO end this fragment coding . Because i didn't end it on purpose
    private TextView autoServiceNameTextView;
    private ImageView autoServiceImageView;
    private Button lookAtMapButton;
    private Button goToWebPageButton;
    private Button makeACallButton;
    private Button showAllServicesButton;
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;

    private AutoServiceDetailContract.Presenter presenter;


    public AutoServiceDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    public static AutoServiceDetailFragment getInstance() {
        return new AutoServiceDetailFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_service_detail, container, false);
        autoServiceNameTextView = (TextView) view.findViewById(R.id.auto_service_name_tv);
        autoServiceImageView = (ImageView) view.findViewById(R.id.auto_service_image_view);
        lookAtMapButton = (Button) view.findViewById(R.id.look_at_map_button);
        goToWebPageButton = (Button) view.findViewById(R.id.go_to_web_page_button);
        makeACallButton = (Button) view.findViewById(R.id.call_button);
        showAllServicesButton = (Button) view.findViewById(R.id.show_all_auto_services_button);
        customizeSpinner(view);

        lookAtMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLookAtMapClicked();
            }
        });

        goToWebPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onGoToWebPageClicked();
            }
        });

        makeACallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMakeCallClicked();
            }
        });

        showAllServicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onShowAllServicesClicked(getActivity());
            }
        });

        return view;
    }

    private void customizeSpinner(View view){
        spinner = (Spinner) view.findViewById(R.id.detail_spinner);
        spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0){
                    presenter.processSelectedSpinnerItem(getActivity(), spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
            presenter = new AutoServiceDetailPresenter(this, getActivity());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getAutoServiceNameAndImage((String) getActivity().getIntent().getExtras().get(EXTRA_AUTO_SERVICE_NAME));
    }

    @Override
    public void setPresenter(AutoServiceDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setAutoServiceName(String autoServiceName) {
        autoServiceNameTextView.setText(autoServiceName);
    }

    @Override
    public void askForCallPermission() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, Constants.getRequestPhoneCall());
    }

    @Override
    public ImageView getImageView() {
        return autoServiceImageView;
    }

    @Override
    public void addDataToSpinnerAdapter(Set<String> services) {
        spinnerAdapter.clear();
        spinnerAdapter.add("Выберете услугу...");
        spinnerAdapter.addAll(services);
        spinnerAdapter.notifyDataSetChanged();
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
