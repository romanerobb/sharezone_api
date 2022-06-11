package com.revature.sharezone.userprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "userprofile")
public class UserProfile {
    @Id
    private String username;

    @NotBlank(message = "input the user's first name")
    @NotNull
    private String fname;

    @NotBlank(message = "input the user's last name")
    @NotNull
    private String lname;

    @NotBlank(message = "input the user's email")
    @NotNull
    private String emailaddress;

    @NotBlank(message = "input the user's password")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(message = "Minimum eight characters, at least one letter, one number and one special character required:", regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String userpassword;

    @NotBlank(message = "input the user's age")
    @NotNull
    private int age;

    @NotBlank(message = "input admin")
    @NotNull
    private boolean is_admin;

    @NotBlank(message = "input the user's subscriber")
    @NotNull
    private boolean is_subscriber;

}