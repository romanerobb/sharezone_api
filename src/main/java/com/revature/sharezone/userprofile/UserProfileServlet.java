package com.revature.sharezone.userprofile;


import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import com.revature.sharezone.util.interfaces.Authable;
import com.revature.sharezone.util.web.SecureEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
public class UserProfileServlet  implements Authable {
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
    @SecureEndpoint(needAdminLoggin = true)
    public List<UserProfile> getAllUserProfiles(){
       return userProfileServices.readAll();
    }
//
//    @GetMapping("/userprofiles")
//    @SecureEndpoint(isLoggedIn = true)
//    public ResponseEntity<List> findAllUserProfiles(){
//        // ResponseEntity takes an Object for the ResponseBody and an HTTP Status Code
//        return new ResponseEntity<>(userProfileServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
//    }

//    @GetMapping("/UserProfileEx")
//    public void userProfileEx(){
//        throw new RuntimeException("Oh no userProfile not auth");
//    }

    @GetMapping("/userprofile/{username}")
    @SecureEndpoint(isLoggedIn = true)
    public ResponseEntity<UserProfile> findUserProfileById(@PathVariable String username){
        UserProfile foundUserProfile = userProfileServices.readById(username);
        return new ResponseEntity<>(foundUserProfile, HttpStatus.OK);
    }

    @GetMapping("/userprofile")
    @SecureEndpoint(isLoggedIn = true)
    public UserProfile findUserProfileByIdQueryParam(@RequestParam String username, HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        UserProfile allowedUser = (UserProfile) httpSession.getAttribute("authUser");
        if( !username.equals(allowedUser.getUsername()) && !allowedUser.isIs_admin() )
            throw new AuthenticationException("You must be logged in with user id : " + username + " or an admin." );
        UserProfile foundUserProfile = userProfileServices.readById(username);
        return foundUserProfile;
    }
//
//    @GetMapping("/data")
//    public int showDataTypeInPath(@RequestParam int x){
//        return x;
//    }

//    @GetMapping("/persEx")
//    public void throwPersEx(){
//        throw new ResourcePersistenceException("How does the handler know what message is being sent here???");
//    }
//
//    @SecureEndpoint(allowedUsers = {"jluis", "jerry2022"}, isLoggedIn = true)
//    @GetMapping("/secEnd")
//    public String secureEndpoint(){
//        return "Hey look at me from the secured endpoint";
//    }

    @PutMapping("/userprofile")
    @SecureEndpoint(isLoggedIn = true)
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile, HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        UserProfile authUser = (UserProfile) httpSession.getAttribute("authUser");
        if( !userProfile.getUsername().equals(authUser.getUsername()) && !authUser.isIs_admin() )
            throw new AuthenticationException("You must be logged in with user id : " + authUser.getUsername() + " or an admin." );

        UserProfile updatedUserProfile = userProfileServices.update(userProfile);
        return new ResponseEntity<>(updatedUserProfile, HttpStatus.OK);
    }

    @DeleteMapping("/userprofile")
    @SecureEndpoint(needAdminLoggin = true)
    public String deleteUserProfileById(@RequestParam String username) {
        if(userProfileServices.delete(username))
            return "delete the userprofile by : " + username + " working";
        else return "failed to delete content :" + username;
    }

}
