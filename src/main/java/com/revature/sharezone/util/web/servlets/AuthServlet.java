package com.revature.sharezone.util.web.servlets;

import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.userprofile.UserProfileServices;
import com.revature.sharezone.util.web.dto.LoginCreds;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
    public void authorizerUser(@RequestBody LoginCreds loginCreds, HttpSession httpSession){
        UserProfile userProfile = userProfileServices.authenticateUserProfile(loginCreds.getUsername(), loginCreds.getUserpassword());
        httpSession.setAttribute("authUser", userProfile);
    }

    @DeleteMapping
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }
}
