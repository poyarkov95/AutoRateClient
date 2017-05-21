package com.example.user.userauthorisation.createaccount;

import android.os.AsyncTask;

import com.example.user.userauthorisation.model.User;
import com.example.user.userauthorisation.remote_logic.URL;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by User on 19.03.2017.
 */

public class CreateAccountPresenter implements CreateAccountContract.Presenter {
    private CreateAccountContract.View view;
    private String userName;
    private String userPassword;
    private String confirmUserPassword;


    public CreateAccountPresenter(CreateAccountContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreateAccountClick() {
        userName = view.getUserName();
        userPassword = view.getPassword();
        confirmUserPassword = view.getPasswordConfirmation();
        new CreateAccountTask().execute();

    }

    private class CreateAccountTask extends AsyncTask<Void, Void, User>{
        // How do I properly pass the post request with my User object ?
        @Override
        protected User doInBackground(Void... voids) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            User user = new User(userName, userPassword, confirmUserPassword);
            return restTemplate.postForObject(URL.getUserRegistration(), user, User.class);
        }

        @Override
        protected void onPostExecute(User user) {
            view.makeToast("User registration completed " + user.getUserName());
            view.startAfterLoginActivity();
        }
    }

}
