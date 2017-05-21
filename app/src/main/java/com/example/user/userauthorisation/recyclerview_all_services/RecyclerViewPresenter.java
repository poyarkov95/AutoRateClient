package com.example.user.userauthorisation.recyclerview_all_services;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.user.userauthorisation.autoservice_detail_activity.AutoServiceDetailActivity;
import com.example.user.userauthorisation.model.AutoService;
import com.example.user.userauthorisation.remote_logic.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by User on 27.04.2017.
 */

public class RecyclerViewPresenter implements RecyclerViewContract.Presenter {

    private RestTemplate restTemplate;
    private RecyclerViewContract.View view;

    public RecyclerViewPresenter(RecyclerViewContract.View view){
        this.view = view;
        new RecyclerViewTask().execute();
    }

    @Override
    public void onRecyclerViewItemClicked(String autoServiceName, Activity activity) {
        Intent intent = new Intent(activity, AutoServiceDetailActivity.class);
        intent.putExtra(AutoServiceDetailActivity.EXTRA_AUTO_SERVICE_NAME, autoServiceName);
        activity.startActivity(intent);
    }

    private class RecyclerViewTask extends AsyncTask<Void, Void, AutoService[]>{

        @Override
        protected AutoService[] doInBackground(Void... voids) {
            restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<AutoService[]> autoServiceEntity = restTemplate.getForEntity(URL.getAllAutoServices(), AutoService[].class);
            return autoServiceEntity.getBody();
        }

        @Override
        protected void onPostExecute(AutoService[] autoServices) {
            view.setAutoServiceListOnAdapter(autoServices);
        }
    }
}
