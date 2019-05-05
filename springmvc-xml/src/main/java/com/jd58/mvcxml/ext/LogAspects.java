package com.jd58.mvcxml.ext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by yanghuitao on 2018/12/8.
 */
@Aspect
@Component
public class LogAspects {
    @Pointcut("execution(public java.util.List<com.jd58.mvcxml.model.Dept> com.jd58.mvcxml.service.IDeptService.*())")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint point) {
        Object[] args = point.getArgs();
        System.out.println(point.getSignature().getName() + " starts: {" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint point) {
        System.out.println(point.getSignature().getName() + " ends...");
    }

//    @AfterReturning(value = "pointCut()", returning = "result")
//    public void logReturn(JoinPoint point, Object result) {
//        System.out.println(point.getSignature().getName() + " returns: {" + result + "}");
//    }
//
//    @AfterThrowing(value = "pointCut()", throwing = "exception")
//    public void logException(JoinPoint point, Exception exception) {
//        System.out.println(point.getSignature().getName() + " exception: {" + exception + "}");
//    }
}