package com.revature.sharezone.util.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ActionsInitalizer {

    private int id;
    private String userstatus;
    private String usercomment;
    private int contentsid;
    private Boolean userlike;
    private String username;

    public ActionsInitalizer(){}

    public ActionsInitalizer(int id, String userstatus, String usercomment, int contentsid, Boolean userlike, String username) {
        this.id = id;
        this.userstatus = userstatus;
        this.usercomment = usercomment;
        this.contentsid = contentsid;
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

    public int getContentsid() {
        return contentsid;
    }

    public void setContentsid(int contentsid) {
        this.contentsid = contentsid;
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
                ", contentsid=" + contentsid +
                ", userlike=" + userlike +
                ", username='" + username + '\'' +
                '}';
    }
}
