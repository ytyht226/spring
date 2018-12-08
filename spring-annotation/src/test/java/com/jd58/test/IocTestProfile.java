package com.jd58.test;

import com.jd58.bean.Yellow;
import com.jd58.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestProfile {

    @Test
    public void test02() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.getEnvironment().setActiveProfiles("test");
        ac.register(MainConfigOfProfile.class);
        ac.refresh();

        String[] namesForType = ac.getBeanNamesForType(DataSource.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
        System.out.println(ac.getBean(Yellow.class));
    }

    @Test
    public void test01() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] namesForType = ac.getBeanNamesForType(DataSource.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

}