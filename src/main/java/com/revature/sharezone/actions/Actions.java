package com.revature.sharezone.actions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actions")

public class Actions {

    @Id
    private int id;
    private String userstatus;
    private String usercomment;
    private Boolean userlike;
    private String username;

    public Actions() {
    }

    public Actions(int id, String userstatus, String usercomment, Boolean userlike, String username) {
        super();
        this.id = id;
        this.userstatus = userstatus;
        this.usercomment = usercomment;
        this.userlike = userlike;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public String getUsercomment() {
        return usercomment;
    }

    public void setUsercomment(String usercomment) {
        this.usercomment = usercomment;
    }

    public Boolean getUserlike() {
        return userlike;
    }

    public void setUserlike(Boolean userlike) {
        this.userlike = userlike;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "id=" + id +
                ", userstatus='" + userstatus + '\'' +
                ", usercomment='" + usercomment + '\'' +
                ", userlike=" + userlike +
                ", username='" + username + '\'' +
                '}';
    }
}
