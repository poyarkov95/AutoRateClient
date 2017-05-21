package com.example.user.userauthorisation.autoservice_detail_activity;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.example.user.userauthorisation.model.AutoService;
import com.example.user.userauthorisation.model.Service;
import com.example.user.userauthorisation.recycler_view_services_info.RecyclerViewServicesInfoActivity;
import com.example.user.userauthorisation.remote_logic.URL;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AutoServiceDetailPresenter implements AutoServiceDetailContract.Presenter {
    private AutoServiceDetailContract.View view;
    private RestTemplate restTemplate;
    private AutoService autoService;
    private Context context;

    public AutoServiceDetailPresenter(AutoServiceDetailContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getAutoServiceNameAndImage(String autoServiceName) {
        new AutoServiceDetailTask().execute(autoServiceName);
    }

    @Override
    public void onLookAtMapClicked() {
        String serviceMapLocationURL = URL.getGoogleMapsUrlTemplate() + autoService.getMapCoordinate();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(serviceMapLocationURL));
        context.startActivity(intent);
    }

    @Override
    public void onGoToWebPageClicked() {
        String webAddress = autoService.getWebsiteURL();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webAddress));
        context.startActivity(intent);
    }

    @Override
    public void onMakeCallClicked() {
        String telephonePath = URL.getTelephonePath() + autoService.getPhoneNumber();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(telephonePath));
        //TODO fix asking call permission
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            view.askForCallPermission();
        } else {
            context.startActivity(intent);
        }
    }

    @Override
    public void onShowAllServicesClicked(Activity activity) {
        Intent intent = new Intent(activity, RecyclerViewServicesInfoActivity.class);
        intent.putExtra(RecyclerViewServicesInfoActivity.EXTRA_AUTO_SERVICE_ID, autoService.getId());
        activity.startActivity(intent);
    }

    @Override
    public void processSelectedSpinnerItem(Activity activity, String serviceCategory) {
        Intent intent = new Intent(activity, RecyclerViewServicesInfoActivity.class);
        intent.putExtra(RecyclerViewServicesInfoActivity.EXTRA_AUTO_SERVICE_ID, autoService.getId());
        intent.putExtra(RecyclerViewServicesInfoActivity.EXTRA_FLAG_FOR_SERVICE, autoService.getServices().get(0).getCategory());
        activity.startActivity(intent);
    }

    private class AutoServiceDetailTask extends AsyncTask<String, Void, AutoService> {
    //TODO FIX HEAR
        @Override
        protected AutoService doInBackground(String... strings) {
            restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            String newURL = URL.getAutoService().concat(strings[0]);
            autoService = restTemplate.getForObject(newURL, AutoService.class);
            return autoService;
        }

        @Override
        protected void onPostExecute(AutoService autoService) {
            view.setAutoServiceName(autoService.getServiceName());
            view.addDataToSpinnerAdapter(getServicesNames(autoService.getServices()));
            Glide.with(context.getApplicationContext()).load(autoService.getImageURL()).into(view.getImageView());
        }

        private Set<String> getServicesNames(List<Service> services){
            Set<String> serviceList = new TreeSet<>();
            for(Service service : services){
                if(service != null){
                    serviceList.add(service.getCategory());
                }
            }
            return serviceList;
        }
    }
}
