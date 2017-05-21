package com.example.user.userauthorisation.createaccount;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.afterloginlogic.AfterLoginActivity;
import com.example.user.userauthorisation.login.LoginPageActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccountFragment extends Fragment implements CreateAccountContract.View {

    private Button createAccountButton;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private EditText userNameEditText;
    private TextView passwordTextView;
    private TextView confirmPasswordTextView;
    private TextView userNameTextView;
    private View contentContainer;

    private CreateAccountContract.Presenter presenter;

    public CreateAccountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);
        contentContainer = view.findViewById(R.id.cont_create_account_content);
        createAccountButton = (Button)view.findViewById(R.id.btn_create_account);
        passwordEditText = (EditText)view.findViewById(R.id.edt_create_password);
        confirmPasswordEditText = (EditText)view.findViewById(R.id.edt_create_confirmation);
        userNameEditText = (EditText)view.findViewById(R.id.edt_create_name);

        passwordTextView = (TextView)view.findViewById(R.id.lbl_create_password_sub);
        confirmPasswordTextView = (TextView)view.findViewById(R.id.lbl_create_confirmation_sub);
        userNameTextView = (TextView)view.findViewById(R.id.lbl_create_name_sub);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onCreateAccountClick();
            }
        });

        setUpListeners();
        userNameEditText.requestFocus();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter == null){
            presenter = new CreateAccountPresenter(this);
        }
    }

    public static CreateAccountFragment getInstance(){
        return new CreateAccountFragment();
    }

    //TODO end this method for another fields
    private void setUpListeners() {
        userNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    userNameTextView.setTextColor(ContextCompat.getColor(getActivity().getApplicationContext(), android.R.color.white));
                } else {
                    ContextCompat.getColor(getActivity().getApplicationContext(), android.R.color.white);
                }
            }
        });
    }

    @Override
    public void makeToast(@StringRes int stringId) {
        Toast.makeText(getActivity().getApplicationContext(), getString(stringId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }

    @Override
    public String getPasswordConfirmation() {
        return confirmPasswordEditText.getText().toString();
    }

    @Override
    public String getUserName() {
        return userNameEditText.getText().toString();
    }

    @Override
    public void startLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void startAfterLoginActivity() {
        Intent intent = new Intent(getActivity(), AfterLoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(CreateAccountContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
