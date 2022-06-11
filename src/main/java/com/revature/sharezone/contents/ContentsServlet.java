package com.revature.sharezone.contents;


import com.revature.sharezone.userprofile.UserProfileServices;
import com.revature.sharezone.util.interfaces.Authable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ContentsServlet implements Authable {

    private final UserProfileServices userProfileServices;
    private final ContentsServices contentsServices;

    @Autowired
    public ContentsServlet(UserProfileServices userProfileServices, ContentsServices contentsServices) {
        this.userProfileServices = userProfileServices;
        this.contentsServices = contentsServices;
    }


    // TODO: IMPLEMENT ME

    @GetMapping("/contents-findall")
    public List<Contents> getAllUserProfiles(){
        return contentsServices.readAll();
    }

    @GetMapping("/contents")
    public ResponseEntity<List> findAllContents(){
        // ResponseEntity takes an Object for the ResponseBody and an HTTP Status Code
        return new ResponseEntity<>(contentsServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }
    // TODO: change this one for logging already
//    @GetMapping("/UserProfileEx")
//    public void userProfileEx(){
//        throw new RuntimeException("Oh no userProfile not auth");
//    }
    @GetMapping("/contents/{id}")
    public ResponseEntity<Contents> findUserProfileById(@PathVariable String id){
        Contents tags = contentsServices.readById(id);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }


    @GetMapping("/contents")
    public Contents findUserProfileByIdQueryParam(@RequestParam String id){
        Contents foundContents = contentsServices.readById(id);
        return foundContents;
    }

    @GetMapping("/data")
    public int showDataTypeInPath(@RequestParam int x){
        return x;
    }




}
