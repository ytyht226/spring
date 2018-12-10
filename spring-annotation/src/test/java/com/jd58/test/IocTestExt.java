package com.jd58.test;

import com.jd58.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestExt {
    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtConfig.class);

    @Test
    public void test01() {
        ac.publishEvent(new ApplicationEvent(new String("my event")) {
        });
        ac.close();

    }

}