package com.concurrency.aspect;

import com.concurrency.NluContext;
import com.concurrency.NluContextHolder;
import com.concurrency.TNluRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by yanghuitao on 2020/2/28.
 */
@Aspect
@Component
public class NluAspect {

    @Around(value = "execution(* com.concurrency.thrift.TNluFacade.*(..)) ")
    public Object doAround(ProceedingJoinPoint point) {
        Object result = null;
        try {
            Object[] args = point.getArgs();
            TNluRequest tNluRequest = (TNluRequest) args[0];

            NluContext context = new NluContext();
            context.setTNluRequest(tNluRequest);
            NluContextHolder.set(context);

            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            NluContextHolder.remove();
        }
        return result;
    }
}