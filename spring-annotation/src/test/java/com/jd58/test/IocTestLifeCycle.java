package com.jd58.test;

import com.jd58.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestLifeCycle {
    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);



    @Test
    public void test01() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanName : beanDefinitionNames) {
//            System.out.println(beanName);
//        }

        ac.close();
    }


}