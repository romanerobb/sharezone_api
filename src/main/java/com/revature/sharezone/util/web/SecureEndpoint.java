package com.revature.sharezone.util.web;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureEndpoint {

    String[] allowedUsers() default {};

    boolean isLoggedIn() default false;

    boolean needAdminLoggin() default false;
}
