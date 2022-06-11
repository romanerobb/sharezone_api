package com.revature.sharezone.util.web.servlets;

import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.userprofile.UserProfileServices;
import com.revature.sharezone.util.web.dto.LoginCredis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

// @WebServlet("/auth") // this requires a default No-Args constructor, but we make our own constructor in line 24
@RestController
@RequestMapping("/auth")
public class AuthServlet {

    private final UserProfileServices userProfileServices;

    @Autowired
    public AuthServlet(UserProfileServices userProfileServices) {
        this.userProfileServices = userProfileServices;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void authorizeUserProfile(@RequestBody LoginCredis loginCreds, HttpSession httpSession) {
        UserProfile authUserProfile = userProfileServices.authenticateUserProfile(loginCreds.getUsername(), loginCreds.getUserpassword());
        httpSession.setAttribute("authTrainer", authUserProfile);
    }

    @DeleteMapping
    public void logout(HttpSession session) {
        session.invalidate();
    }
}