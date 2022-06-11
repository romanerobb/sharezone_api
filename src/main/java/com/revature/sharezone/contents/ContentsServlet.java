package com.revature.sharezone.contents;


import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.userprofile.UserProfileServices;
import com.revature.sharezone.util.interfaces.Authable;

import com.revature.sharezone.util.web.dto.ContentsInitializer;
import com.revature.sharezone.util.web.dto.LoginCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/contents")
public class ContentsServlet implements Authable {
    
//    private final UserProfileServices userProfileServices;
    private final ContentsServices contentsServices;

    @Autowired
    public ContentsServlet(ContentsServices contentsServices) {
        this.contentsServices = contentsServices;
    }



//    public ContentsServlet(UserProfileServices userProfileServices, ContentsServices contentsServices) {
//        this.userProfileServices = userProfileServices;
//        this.contentsServices = contentsServices;
//    }


    // TODO: IMPLEMENT ME

    @GetMapping()
    public List<Contents> findAllContents(){
        return contentsServices.readAll();
    }

//    @GetMapping()
//    public ResponseEntity<List> findAllContents(){
//        // ResponseEntity takes an Object for the ResponseBody and an HTTP Status Code
//        return new ResponseEntity<>(contentsServices.readAll(), HttpStatus.I_AM_A_TEAPOT);
//    }
    // TODO: change this one for logging already
//    @GetMapping("/UserProfileEx")
//    public void userProfileEx(){
//        throw new RuntimeException("Oh no userProfile not auth");
//    }
//    @GetMapping("/contents/{id}")
//    public ResponseEntity<Contents> findContentsById(@RequestParam String id){
//        Contents contents = contentsServices.readById(id);
//        return new ResponseEntity<>(contents, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Contents> findContentsById(@PathVariable String id){
        Contents contents = contentsServices.readById(id);
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Contents> saveUserProfile(@RequestBody Contents contents){
        Contents newContents = contentsServices.create(contents);
        return new ResponseEntity<>(newContents, HttpStatus.CREATED);
    }


    @DeleteMapping()
    public String deleteContentsById(@RequestParam String id) {
        contentsServices.delete(id);
        return "delete content : " + id + " working";
    }


    @PutMapping()
    public ResponseEntity<Contents> updateContent(@RequestBody Contents contents){
        Contents updatedContents = contentsServices.update(contents);
        return new ResponseEntity<>(updatedContents, HttpStatus.OK);
    }
    
    
}
