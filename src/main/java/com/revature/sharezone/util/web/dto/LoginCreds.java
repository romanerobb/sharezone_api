package com.revature.sharezone.util.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
public class LoginCreds {

    private String username;
    private String userpassword;


    public LoginCreds(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "LoginCreds{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
