package com.revature.sharezone.tags;

import javax.persistence.*;

// import com.revature.sharezone.user_profile.UserProfile;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String favorite_city;
    private String favorite_team;
    private String favorite_movie;
    private String favorite_tvshow;
    private String favorite_character;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserProfile userProfile;
    //private String username;

    public Tags() {}

    public Tags(int id, String favorite_city, String favorite_team, String favorite_movie, String favorite_tvshow, String favorite_character, UserProfile userProfile) {
        this.id = id;
        this.favorite_city = favorite_city;
        this.favorite_team = favorite_team;
        this.favorite_movie = favorite_movie;
        this.favorite_tvshow = favorite_tvshow;
        this.favorite_character = favorite_character;
        this.userProfile = userProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavorite_city() {
        return favorite_city;
    }

    public void setFavorite_city(String favorite_city) {
        this.favorite_city = favorite_city;
    }

    public String getFavorite_team() {
        return favorite_team;
    }

    public void setFavorite_team(String favorite_team) {
        this.favorite_team = favorite_team;
    }

    public String getFavorite_movie() {
        return favorite_movie;
    }

    public void setFavorite_movie(String favorite_movie) {
        this.favorite_movie = favorite_movie;
    }

    public String getFavorite_tvshow() {
        return favorite_tvshow;
    }

    public void setFavorite_tvshow(String favorite_tvshow) {
        this.favorite_tvshow = favorite_tvshow;
    }

    public String getFavorite_character() {
        return favorite_character;
    }

    public void setFavorite_character(String favorite_character) {
        this.favorite_character = favorite_character;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }


    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", favorite_city='" + favorite_city + '\'' +
                ", favorite_team='" + favorite_team + '\'' +
                ", favorite_movie='" + favorite_movie + '\'' +
                ", favorite_tvshow='" + favorite_tvshow + '\'' +
                ", favorite_character='" + favorite_character + '\'' +
                ", userProfile=" + userProfile +
                '}';
    }
}
