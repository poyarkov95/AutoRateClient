package com.example.user.userauthorisation.model;

import java.util.List;

/**
 * Created by User on 28.04.2017.
 */

public class AutoService {
    private long id;
    private String serviceName;
    private String imageURL;
    private String mapCoordinate;
    private String websiteURL;
    private String phoneNumber;
    private List<Service> services;

    public AutoService() {
    }

    public AutoService(long id, String serviceName, String imageURL, String mapCoordinate, String websiteURL, String phoneNumber, List<Service> services) {
        this.id = id;
        this.serviceName = serviceName;
        this.imageURL = imageURL;
        this.mapCoordinate = mapCoordinate;
        this.websiteURL = websiteURL;
        this.phoneNumber = phoneNumber;
        this.services = services;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMapCoordinate() {
        return mapCoordinate;
    }

    public void setMapCoordinate(String mapCoordinate) {
        this.mapCoordinate = mapCoordinate;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
