package com.revature.sharezone.util.web.servlets;


import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import com.revature.sharezone.util.web.dto.ActionsInitalizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/test")
public class TestServlet {

    @GetMapping("/1")
    public @ResponseBody String test(){
        return "Welcome to the wonderful world of Spring";
    }

    @GetMapping("/2")
    public @ResponseBody String test2(){
        return "Hey, this is another get method. nice right.";
    }

    @PostMapping("/post-test")
    public @ResponseBody String postTest(@RequestBody UserProfile userProfile){
        return userProfile.toString();
    }

    @PostMapping("/post-actions")
    public @ResponseBody ActionsInitalizer postTestAction(@RequestBody ActionsInitalizer actions){
        return actions;
    }
//
//    @GetMapping("/testException")
//    public void testException(){
//        throw new InvalidRequestException("Boooo don't hit this endpoint");
//    }
//
//    @GetMapping("/testException1")
//    public void testException1(){
//        throw new InvalidRequestException("Boooo don't hit this endpoint");
//    }
//    @GetMapping("/testException2")
//    public void testException2(){
//        throw new InvalidRequestException("Boooo don't hit this endpoint");
//    }
//    @GetMapping("/testException3")
//    public void testException3(){
//        throw new InvalidRequestException("Boooo don't hit this endpoint");
//    }
//
//    @GetMapping("/testException4")
//    public void testException4(){
//        throw new AuthenticationException("Boooo don't hit this unauthorized endpoint");
//    }


}
