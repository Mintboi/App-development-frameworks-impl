// LoggingAspect.java
package com.Project.MartinSwiftImpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.Project.MartinSwiftImpl.Services.*.*(..))")
    public void logBeforeServiceMethods(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.Project.MartinSwiftImpl.Services.*.*(..))", returning = "result")
    public void logAfterServiceMethods(JoinPoint joinPoint, Object result) {
        System.out.println("Executed: " + joinPoint.getSignature() + " with result: " + result);
    }
}
