package com.revature.sharezone.contents;


import com.revature.sharezone.userprofile.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data       // It handels toString, hasCode, equals() getters and setters
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "contents")
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "input the section")
    @NotNull
    private String section;

    @NotBlank(message = "input the content")
    @NotNull
    private String postcontent;

    private String displaypicture;

    @NotBlank(message = "input the post date")
    @NotNull
    private String postdate;

    @ManyToMany
    @JoinColumn(name="username",  referencedColumnName="username")
    private UserProfile username;

}
