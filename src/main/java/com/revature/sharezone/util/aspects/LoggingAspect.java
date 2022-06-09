package com.revature.sharezone.util.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger();

    @Pointcut ("within(com.revature..*)")
    public void logAll(){};

    private String extractMethodSignature(JoinPoint jp) {
        return jp.getTarget().getClass().toString() + "#" + jp.getSignature().getName();
    }

    @Before("logAll()")
    public void logMethodStart(JoinPoint jp) {
        // ClassName#getMethodeName
        String methodSignature = extractMethodSignature(jp);
        String methodAruments = Arrays.toString(jp.getArgs()); // getArgs() return Object[]
        logger.info("{} successfully invoked at {} with provided argument: {}",
                methodSignature, LocalDateTime.now().toString(), methodAruments);
    }

    @AfterReturning(pointcut = "logAll()", returning = "returnedObject")
    public void logMethodReturn(JoinPoint jp, Object returnObject) {
        logger.info("{} was successfully returned at {} with value: {}",
                extractMethodSignature(jp), LocalDateTime.now().toString(), returnObject);
    }

    @AfterThrowing(pointcut = "logAll()", throwing = "t")
    public void logMethodException(JoinPoint jp, Throwable t) {
        String methodSignature = extractMethodSignature(jp);
        String throwableName = t.getClass().getName();
        logger.info("{} was thrown in {} at {} with value: {}",
                throwableName, methodSignature, LocalDateTime.now().toString(),t.getMessage() );
    }




}
