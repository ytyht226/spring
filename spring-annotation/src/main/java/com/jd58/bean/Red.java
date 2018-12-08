package com.jd58.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by yanghuitao on 2018/12/7.
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("the ioc passed: " + applicationContext);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name: " + name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("resolver: " + resolver);
        String stringValue = resolver.resolveStringValue("hello ${os.name}");
        System.out.println("resolved str: " + stringValue);
    }
}