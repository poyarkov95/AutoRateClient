package com.example.user.userauthorisation.model;

/**
 * Created by User on 28.04.2017.
 */

public class Service {
    private long serviceId;
    private String serviceName;
    private String category;
    private int price;

    public Service() {
    }

    public Service(long serviceId, String serviceName, String category, int price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.category = category;
        this.price = price;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
