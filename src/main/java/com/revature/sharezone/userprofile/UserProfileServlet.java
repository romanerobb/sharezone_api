package com.revature.sharezone.userprofile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserProfileServlet implements Authable{

    private final UserProfileServices userProfileServices;

    @Autowired
    public UserProfileServlet(UserProfileServices userProfileServices) {
        this.userProfileServices = userProfileServices;
    }

    // TODO: Implement ME


    // Create
    @PostMapping("/register")
    public ResponseEntity<UserProfile> saveUserProfile(@RequestBody UserProfile userProfile){
        UserProfile newUserProfile = userProfileServices.create(userProfile);
        return new ResponseEntity<>(newUserProfile, HttpStatus.CREATED);
    }


    @GetMapping("/userprofile-findall")
    public List<UserProfile> getAllUserProfiles(){
        return userProfileServices.readAll();
    }

    @GetMapping("/userprofiles")
    public ResponseEntity<List> findAllUserProfiles(){
        // ResponseEntity takes an Object for the ResponseBody and an HTTP Status Code
        return new ResponseEntity<>(userProfileServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/UserProfileEx")
    public void userProfileEx(){
        throw new AuthenticationException("Oh no userProfile not auth");
    }

    @GetMapping("/userprofile/{email}")
    public ResponseEntity<UserProfile> findUserProfileById(@PathVariable String username){
        UserProfile foundUserProfile = userProfileServices.readById(username);
        return new ResponseEntity<>(foundUserProfile, HttpStatus.OK);
    }

    @GetMapping("/userprofile")
    public UserProfile findUserProfileByIdQueryParam(@RequestParam String username){
        UserProfile foundUserProfile = userProfileServices.readById(username);
        return foundUserProfile;
    }

    @GetMapping("/data")
    public int showDataTypeInPath(@RequestParam int x){
        return x;
    }



}
