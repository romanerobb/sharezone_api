package com.revature.sharezone.util.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ActionsInitalizer {

    private int id;
    private String userstatus;
    private String usercomment;
    private int contentid;
    private Boolean userlike;
    private String username;

    public ActionsInitalizer(){}

    public ActionsInitalizer(int id, String userstatus, String usercomment, int contentid, Boolean userlike, String username) {
        this.id = id;
        this.userstatus = userstatus;
        this.usercomment = usercomment;
        this.contentid = contentid;
        this.userlike = userlike;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
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
        return "ActionsInitalizer{" +
                "id=" + id +
                ", userstatus='" + userstatus + '\'' +
                ", usercomment='" + usercomment + '\'' +
                ", contentid=" + contentid +
                ", userlike=" + userlike +
                ", username='" + username + '\'' +
                '}';
    }
}
