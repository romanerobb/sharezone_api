package com.revature.sharezone.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ActionsServlet {

    private final ActionsServices actionsServices;

    @Autowired
    public ActionsServlet(ActionsServices actionsServices) {
        this.actionsServices = actionsServices;
    }


}
