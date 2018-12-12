package com.jd58.test;

import com.jd58.bean.Blue;
import com.jd58.bean.Color;
import com.jd58.bean.Person;
import com.jd58.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTest {
    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void testImport() {
        printBeans(ac);
        Blue blue = ac.getBean(Blue.class);
        System.out.println(blue);

        Object bean1 = ac.getBean("colorFactoryBean");
        Object bean2 = ac.getBean("&colorFactoryBean");
        System.out.println("bean1's type: " + bean1.getClass());
        System.out.println("bean2's type: " + bean2.getClass());
    }

    private void printBeans(ApplicationContext ac) {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {
        String[] namesForType = ac.getBeanNamesForType(Person.class);

        Environment environment = ac.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String beanName : namesForType) {
            System.out.println(beanName);
        }

        Map<String, Person> beansOfType = ac.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void test02() {
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanName : beanDefinitionNames) {
//            System.out.println(beanName);
//        }
        Person person = ac.getBean("person", Person.class);
        Color color = ac.getBean("colorFactoryBean", Color.class);
//        Person person2 = ac.getBean("person", Person.class);
//        System.out.println(person == person2);
    }

    @Test
    public void test01() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }


}