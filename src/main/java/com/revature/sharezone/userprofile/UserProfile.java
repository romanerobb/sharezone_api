package com.revature.sharezone.userprofile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userprofile")
public class UserProfile {
    @Id
    private String username;
    private String fname;
    private String lname;

    private String emailaddress;
    //    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userpassword;
    private int age;
    private boolean is_admin;
    private boolean is_subscriber;

    public UserProfile(String username, String fname, String lname, String emailaddress, String userpassword, int age, boolean is_admin, boolean is_subscriber) {
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.emailaddress = emailaddress;
        this.userpassword = userpassword;
        this.age = age;
        this.is_admin = is_admin;
        this.is_subscriber = is_subscriber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isIs_subscriber() {
        return is_subscriber;
    }

    public void setIs_subscriber(boolean is_subscriber) {
        this.is_subscriber = is_subscriber;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "username='" + username + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", emailaddress='" + emailaddress + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", age=" + age +
                ", is_admin=" + is_admin +
                ", is_subscriber=" + is_subscriber +
                '}';
    }
}