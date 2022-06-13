package com.revature.sharezone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// This for @Configuration, @ComponentScan and @EnableAutoConfiguration (@EnableWebMvc too)
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SharezoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharezoneApplication.class, args);
    }

}