package com.revature.sharezone.tags;

import com.revature.sharezone.util.interfaces.Authable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TagsServlets implements Authable {

    private final TagsServices tagsServices;
    private final UserProfile userProfile;

    @Autowired

    public TagsServlets(TagsServices tagsServices, UserProfile userProfile) {
        this.tagsServices = tagsServices;
        this.userProfile = userProfile;
    }
    // TODO: IMPLEMENT ME





}
