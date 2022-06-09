package com.revature.sharezone.userprofile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserProfileServlet implements Authable{

    private final UserProfileServices userProfileServices;

    @Autowired
    public UserProfileServlet(UserProfileServices userProfileServices) {
        this.userProfileServices = userProfileServices;
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

}
