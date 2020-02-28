package com.nlu.aspect;

import com.nlu.NluContext;
import com.nlu.NluContextHolder;
import com.nlu.TNluRequest;
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

    @Around(value = "execution(* com.nlu.thrift.TNluFacade.*(..)) ")
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