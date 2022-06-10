package com.revature.sharezone.util.web.servlets;

import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
        public @ResponseBody UserProfile postTest(@RequestBody UserProfile userProfile){
            return userProfile;
        }

        @GetMapping("/testException")
        public void testException(){
            throw new InvalidRequestException("Boooo don't hit this endpoint");
        }

        @GetMapping("/testException1")
        public void testException1(){
            throw new InvalidRequestException("Boooo don't hit this endpoint");
        }
        @GetMapping("/testException2")
        public void testException2(){
            throw new InvalidRequestException("Boooo don't hit this endpoint");
        }
        @GetMapping("/testException3")
        public void testException3(){
            throw new InvalidRequestException("Boooo don't hit this endpoint");
        }

        @GetMapping("/testException4")
        public void testException4(){
            throw new AuthenticationException("Boooo don't hit this unauthorized endpoint");
        }

    }
