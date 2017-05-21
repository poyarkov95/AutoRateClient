package com.example.user.userauthorisation.recycler_view_services_info;


import android.os.AsyncTask;

import com.example.user.userauthorisation.model.Service;
import com.example.user.userauthorisation.remote_logic.URL;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RecyclerViewServicesInfoPresenter implements RecyclerViewServicesInfoContract.Presenter {

    private RecyclerViewServicesInfoContract.View view;
    private RestTemplate restTemplate;
    private String customURL;


    public RecyclerViewServicesInfoPresenter(RecyclerViewServicesInfoContract.View view) {
        this.view = view;
    }

    @Override
    public void getObjectsForRecyclerView(Long autoServiceId, String serviceCategory) {
        if (serviceCategory != null) {
            customURL = String.format(URL.getCertainServices(), autoServiceId, serviceCategory);
        } else {
            customURL = String.format(URL.getAllServices(), autoServiceId);
        }
        new AutoServiceDetailTask().execute();
    }

    private class AutoServiceDetailTask extends AsyncTask<Object, Object, Service[]> {

        @Override
        protected Service[] doInBackground(Object... voids) {
            restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(customURL, Service[].class);
        }

        @Override
        protected void onPostExecute(Service[] services) {
            view.setServicesListOnAdapter(services);
        }
    }
}
