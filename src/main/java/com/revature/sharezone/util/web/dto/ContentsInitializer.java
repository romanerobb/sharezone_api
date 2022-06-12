package com.revature.sharezone.util.web.dto;

import com.revature.sharezone.userprofile.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ContentsInitializer {
    private int id;
    private String section;
    private String postcontent;
    private String displaypicture;
    private String postdate;
    private String username;

    public ContentsInitializer(){}

    public ContentsInitializer(int id, String section, String postcontent, String displaypicture, String postdate, String username) {
        this.id = id;
        this.section = section;
        this.postcontent = postcontent;
        this.displaypicture = displaypicture;
        this.postdate = postdate;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public String getDisplaypicture() {
        return displaypicture;
    }

    public void setDisplaypicture(String displaypicture) {
        this.displaypicture = displaypicture;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ContentsInitializer{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", postcontent='" + postcontent + '\'' +
                ", displaypicture='" + displaypicture + '\'' +
                ", postdate='" + postdate + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}