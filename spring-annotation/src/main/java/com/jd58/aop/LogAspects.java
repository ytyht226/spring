package com.jd58.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by yanghuitao on 2018/12/8.
 */
@Aspect
public class LogAspects {
    @Pointcut("execution(public int com.jd58.aop.MathCalculator.*(..))")
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

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint point, Object result) {
        System.out.println(point.getSignature().getName() + " returns: {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint point, Exception exception) {
        System.out.println(point.getSignature().getName() + " exception: {" + exception + "}");
    }
}