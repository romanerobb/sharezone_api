package com.revature.sharezone.actions;

import com.revature.sharezone.userprofile.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@CrossOrigin
public class ActionsServlet {

    private final ActionsServices actionsServices;

    @Autowired
    public ActionsServlet(ActionsServices actionsServices) {
        this.actionsServices = actionsServices;
    }

    @PostMapping("/actions")
    public ResponseEntity<UserProfile> saveActions(@RequestBody Actions actions){
        Actions newActions = actionsServices.create(actions);
        return new ResponseEntity<>(newActions, HttpStatus.CREATED);
    }



}
