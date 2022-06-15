package com.revature.sharezone.util.aspects;

import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.web.SecureEndpoint;
import org.apache.catalina.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AuthAspect {

    // We will get cookies from frontend
    //              which like Axios and Fetch do not handle.
    private HttpServletRequest request;

    @Autowired
    public AuthAspect(HttpServletRequest request) {
        this.request = request;
    }

    // ProceedingJoinEndPoint is looking for any annotations from the above of the method signature
    // We want to do this anything has the SecureEndpoint annotation

    @Around("@annotation(com.revature.sharezone.util.web.SecureEndpoint)")
    public Object secureEndpoints(ProceedingJoinPoint pjp) throws Throwable {

        // This code looking
        // Any method in any execution looking above to see
        // if there's SecureEndpoint , then get a value otherwise it is null
        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        SecureEndpoint anno = method.getAnnotation(SecureEndpoint.class);

        List<String> allowedUsers = Arrays.asList(anno.allowedUsers());
        HttpSession httpSession = request.getSession(false);

        if(httpSession == null)
            throw new AuthenticationException("No session has been found, please login");

        UserProfile userProfile = (UserProfile) httpSession.getAttribute("authUser");

        if(anno.isLoggedIn() == true && userProfile == null )
            throw new AuthenticationException("Please log in before requesting this endpoint.");

        System.out.println("userProfile: " + userProfile );
        if(!allowedUsers.isEmpty() && !allowedUsers.contains(userProfile.getUsername()))
            throw new AuthenticationException("Forbidden request made to sensitive endpoint by user" + userProfile.getUsername());

        if(anno.needAdminLoggin() == true && !userProfile.isIs_admin() )
            throw new AuthenticationException("You need admin privileges to run this endpoint.");

        // This continues to execute the method in question ( method below the @SecureEndpoint annotation)
        Object returned = pjp.proceed();

        return returned;

    }
}
