package com.jd58.test;

import com.jd58.bean.Person;
import com.jd58.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestPropertyValue {
    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);



    @Test
    public void test01() {
        printBeans(ac);
        System.out.println("==========");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);

        ConfigurableEnvironment env = ac.getEnvironment();
        String property = env.getProperty("person.nickName");
        System.out.println(property);
        ac.close();
    }

    private void printBeans(ApplicationContext ac) {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }


}