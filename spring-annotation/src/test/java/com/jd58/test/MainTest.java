package com.jd58.test;

import com.jd58.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yht on 2018/12/6.
 */
public class MainTest {

    @Test
    public void testXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
    }
}