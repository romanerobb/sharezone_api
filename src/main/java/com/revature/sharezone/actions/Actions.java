package com.revature.sharezone.actions;

import com.revature.sharezone.contents.Contents;
import com.revature.sharezone.userprofile.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "actions")

public class Actions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "input the user's status")
    @NotNull
    private String userstatus;

    @NotBlank(message = "input the comment")
    @NotNull
    private String usercomment;

    @NotBlank(message = "input the content id")
    @ManyToOne
    @JoinColumn(name = "contentsid", referencedColumnName = "id")
    private Contents contentid;

    @NotBlank(message = "do you like?")
    @NotNull
    private Boolean userlike;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserProfile username;
}
