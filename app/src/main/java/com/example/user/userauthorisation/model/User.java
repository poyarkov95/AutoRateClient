package com.example.user.userauthorisation.model;

/**
 * Created by User on 25.03.2017.
 */

public class User {
    private Long id;
    private String userName;
    private String userPassword;
    private String confirmPassword;

    public User() {
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String userName, String userPassword, String confirmationPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.confirmPassword = confirmationPassword;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
