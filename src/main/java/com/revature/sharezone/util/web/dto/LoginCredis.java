package com.revature.sharezone.util.web.dto;

public class LoginCredis {

    private String username;
    private String userpassword;

    // JACKSON REQUIRES A NO ARG CONSTRUCTOR

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserPassword(String userpassword) {
        this.userpassword = userpassword;
    }
}