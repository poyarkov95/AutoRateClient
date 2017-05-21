package com.example.user.userauthorisation.login;

import android.os.AsyncTask;

import com.example.user.userauthorisation.model.User;
import com.example.user.userauthorisation.remote_logic.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class LoginPagePresenter implements LoginPageContract.Presenter{
    private LoginPageContract.View view;
    private String userName;
    private String userPassword;
    private RestTemplate restTemplate;
    private ResponseEntity<String> responseEntity;


    public LoginPagePresenter(LoginPageContract.View view) {
        this.view = view;
    }

    @Override
    public void onLoginClicked() {
        userName = view.getUserName();
        userPassword = view.getPassword();
        new LoginUserTask().execute();
    }
//TODO BIG TODO END WRONG LOGIN VARIFICATION
    @Override
    public void onRegisterClicked() {
        view.startCreateAccountActivity();
    }

    private class LoginUserTask extends AsyncTask<Void, Void, User> {
        @Override
        protected User doInBackground(Void... voids) {
            restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            User user = new User(userName, userPassword);
            responseEntity = restTemplate.postForEntity(URL.getUserLogin(), user, String.class);
            return restTemplate.postForObject(URL.getUserLogin(), user, User.class);
        }

        @Override
        protected void onPostExecute(User user) {
            HttpStatus responseStatus = responseEntity.getStatusCode();
            if(responseStatus.equals(HttpStatus.ACCEPTED)){
                view.makeToast("User login completed ");
                view.startAfterLoginActivity();
            } else {
                view.makeToast("User login or password is not correct");
            }
        }
    }

}
