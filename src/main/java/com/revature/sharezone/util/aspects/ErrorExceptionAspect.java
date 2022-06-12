package com.revature.sharezone.util.aspects;

import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.io.IOException;

@RestControllerAdvice
public class ErrorExceptionAspect {

    @ExceptionHandler({InvalidRequestException.class, IOException.class})
    public ResponseEntity<String> handelException(Exception e) {
        String message = "Caught the invalid request with :" + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException2(Exception e) {
        String message = "Caught the invalid request2 with " + e.getMessage();
        System.out.println(message);
    }
//      This code is just same with upper handleExceptio2.
//
//    @ExceptionHandler({AuthenticationException.class})
//    public ResponseEntity<String> handleException2(Exception e) {
//        String message = "Caught the invalid request2 with " + e.getMessage();
//        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler({ResourcePersistenceException.class})
    public ResponseEntity<String> handleException3(Exception e) {
        String message = "Caught the invalid request3 with :" + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> validationException(Exception e) {
        String message = "Caught the invalid request3 with :" + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }





}