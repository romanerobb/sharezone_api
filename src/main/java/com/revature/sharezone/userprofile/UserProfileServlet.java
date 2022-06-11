package com.revature.sharezone.userprofile;


import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import com.revature.sharezone.util.web.SecureEndpoint;
import com.revature.sharezone.util.web.dto.LoginCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserProfileServlet {

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
    @SecureEndpoint(allowedUsers = {"jluis", "jerry2022"}, isLoggedIn = true)
    public ResponseEntity<List> findAllUserProfiles(){
        // ResponseEntity takes an Object for the ResponseBody and an HTTP Status Code
        return new ResponseEntity<>(userProfileServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/UserProfileEx")
    public void userProfileEx(){
        throw new RuntimeException("Oh no userProfile not auth");
    }

    @GetMapping("/userprofile/{username}")
    @SecureEndpoint(isLoggedIn = true)
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

    @GetMapping("/persEx")
    public void throwPersEx(){
        throw new ResourcePersistenceException("How does the handler know what message is being sent here???");
    }

    @SecureEndpoint(allowedUsers = {"jluis", "jerry2022"}, isLoggedIn = true)
    @GetMapping("/secEnd")
    public String secureEndpoint(){
        return "Hey look at me from the secured endpoint";
    }

    @PutMapping("/userprofile")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile){
        UserProfile updatedUserProfile = userProfileServices.update(userProfile);
        return new ResponseEntity<>(updatedUserProfile, HttpStatus.OK);
    }

    @DeleteMapping("/userprofile/{username}")
    public Map<String, Boolean> deleteUserProfileById(@RequestParam String username) {
        userProfileServices.delete(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }



//    @PostMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void authorizerUser(@RequestBody LoginCreds loginCreds, HttpSession httpSession){
//        UserProfile userProfile = userProfileServices.authenticateUserProfile(loginCreds.getUsername(), loginCreds.getUserpassword());
//        httpSession.setAttribute("authUser", userProfile);
//    }
//
//    @DeleteMapping
//    public void logout(HttpSession httpSession) {
//        httpSession.invalidate();
//    }
//
//




}
