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



    // TODO: change this one for logging already


    @GetMapping()
    public List<Contents> findAllContents(){
        return contentsServices.readAll();
    }


    @GetMapping("/findById")
    public ResponseEntity<Contents> findContentsById(@RequestParam String id){
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
