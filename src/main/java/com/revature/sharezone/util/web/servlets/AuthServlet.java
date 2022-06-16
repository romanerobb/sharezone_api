package com.revature.sharezone.util.web.servlets;

import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.userprofile.UserProfileServices;
import com.revature.sharezone.util.web.dto.LoginCreds;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthServlet {

    private final UserProfileServices userProfileServices;

    @Autowired
    public AuthServlet(UserProfileServices userProfileServices) {
        this.userProfileServices = userProfileServices;
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void authorizerUser(@RequestBody LoginCreds loginCreds, HttpSession httpSession){
//        UserProfile authUser = userProfileServices.authenticateUserProfile(loginCreds.getUsername(), loginCreds.getUserpassword());
//        httpSession.setAttribute("authUser", authUser);
//    }

    @PostMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<UserProfile> authorizerUser(@RequestBody LoginCreds loginCreds, HttpSession httpSession){

        System.out.println("LoginCreds: " + loginCreds);
        UserProfile authUser = userProfileServices.authenticateUserProfile(loginCreds.getUsername(), loginCreds.getUserpassword());
        httpSession.setAttribute("authUser", authUser);
        return new ResponseEntity<>(authUser, HttpStatus.OK);
    }


    @DeleteMapping
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }
}
