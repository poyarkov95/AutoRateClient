package com.example.user.userauthorisation.login;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.userauthorisation.R;
import com.example.user.userauthorisation.afterloginlogic.AfterLoginActivity;
import com.example.user.userauthorisation.createaccount.CreateAccountActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginPageFragment extends Fragment implements LoginPageContract.View {

    private Button loginButton;
    private Button registerButton;
    private TextView userNameTextView;
    private TextView userPasswordTextView;
    private EditText userNameEditText;
    private EditText userPasswordEditText;
    private View contentContainer;

    private LoginPageContract.Presenter presenter;


    public LoginPageFragment() {
        // Required empty public constructor
    }

    public static LoginPageFragment getInstance() {
        return new LoginPageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginButton = (Button) view.findViewById(R.id.btn_login);
        registerButton = (Button) view.findViewById(R.id.btn_create_account);
        userNameTextView = (TextView) view.findViewById(R.id.lbl_login_name_sub);
        userPasswordTextView = (TextView) view.findViewById(R.id.lbl_login_password_sub);
        contentContainer = view.findViewById(R.id.cont_login_content);
        userNameEditText = (EditText) view.findViewById(R.id.edt_login_name);
        userPasswordEditText = (EditText) view.findViewById(R.id.edt_login_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLoginClicked();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onRegisterClicked();
            }
        });
        
        setUpListeners();
        userNameEditText.requestFocus();

        return view;
    }

    //TODO end this method
    private void setUpListeners() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null) {
            presenter = new LoginPagePresenter(this);
        }
    }

    @Override
    public String getUserName() {
        return userNameEditText.getText().toString();
    }

    @Override
    public String getPassword() {
        return userPasswordEditText.getText().toString();
    }

    @Override
    public void startAfterLoginActivity() {
        Intent intent = new Intent(getActivity(), AfterLoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void startCreateAccountActivity() {
        Intent intent = new Intent(getActivity(), CreateAccountActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(LoginPageContract.Presenter presenter) {
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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
