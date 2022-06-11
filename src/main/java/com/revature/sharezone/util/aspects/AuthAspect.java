package com.revature.sharezone.util.aspects;

import com.revature.sharezone.userprofile.UserProfile;

import com.revature.sharezone.util.web.SecureEndpoint;
import org.apache.catalina.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AuthAspect {

    private HttpServletRequest request;

    @Autowired
    public AuthAspect(HttpServletRequest request) {
        this.request = request;
    }

    public Object secureEndpoints(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        SecureEndpoint anno = method.getAnnotation(SecureEndpoint.class);

        List<String> allowedUsers = Arrays.asList(anno.allowedUsers());
        HttpSession httpSession = request.getSession(false);

        if(httpSession == null)
            throw new AuthenticationException("No session has been found, please login");

        UserProfile userProfile = (UserProfile) httpSession.getAttribute("authUser");
        if(!allowedUsers.contains(userProfile.getUsername()))
            throw new AuthenticationException("Forbiden User");

        Object returned = pjp.proceed();

        return returned;

    }
}
