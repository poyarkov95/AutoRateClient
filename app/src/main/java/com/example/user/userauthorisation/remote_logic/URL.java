package com.example.user.userauthorisation.remote_logic;

/**
 * Created by User on 26.03.2017.
 */

public class URL {
    private static final String HOST = "http://192.168.0.80:8080/";
    private static final String USER_REGISTRATION = HOST + "user/registration";
    private static final String USER_LOGIN = HOST + "user/login";
    private static final String ALL_AUTO_SERVICES = HOST + "/directory/getAllAutoServices";
    private static final String AUTO_SERVICE = HOST + "directory/getAutoService/";
    private static final String GOOGLE_MAPS_URL_TEMPLATE = "http://maps.google.com/maps?daddr=";
    private static final String TELEPHONE_PATH = "tel:";
    private static final String GET_CERTAIN_SERVICES = HOST + "/directory/getCertainServices/%s/%s";
    private static final String GET_ALL_SERVICES = HOST + "/directory/getAllServices/%s";

    public static String getUserRegistration() {
        return USER_REGISTRATION;
    }

    public static String getUserLogin() {
        return USER_LOGIN;
    }

    public static String getAllAutoServices() {
        return ALL_AUTO_SERVICES;
    }

    public static String getAutoService() {
        return AUTO_SERVICE;
    }

    public static String getGoogleMapsUrlTemplate() {
        return GOOGLE_MAPS_URL_TEMPLATE;
    }

    public static String getTelephonePath() {
        return TELEPHONE_PATH;
    }

    public static String getCertainServices() {
        return GET_CERTAIN_SERVICES;
    }

    public static String getAllServices() {
        return GET_ALL_SERVICES;
    }
}
