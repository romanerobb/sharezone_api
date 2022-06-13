package com.revature.sharezone.contents;


import com.revature.sharezone.userprofile.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;




@Entity
@Table(name = "contents")
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String section;


    private String postcontent;

    private String displaypicture;


    private String postdate;

    @ManyToOne
    @JoinColumn(name="username",  referencedColumnName="username")
    private UserProfile username;

    public Contents() {}
    public Contents(int id, String section, String postcontent, String displaypicture, String postdate, UserProfile username) {
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

    public UserProfile getUsername() {
        return username;
    }

    public void setUsername(UserProfile username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", postcontent='" + postcontent + '\'' +
                ", displaypicture='" + displaypicture + '\'' +
                ", postdate='" + postdate + '\'' +
                ", username=" + username +
                '}';
    }
}
