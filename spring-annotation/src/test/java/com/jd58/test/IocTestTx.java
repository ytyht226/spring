package com.jd58.test;

import com.jd58.tx.TxConfig;
import com.jd58.tx.UserService;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestTx {


    @Test
    public void test01() {
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\class");
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
//        UserService userService = ac.getBean(UserService.class);
//        userService.insertUser();
    }

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\class");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = ac.getBean(UserService.class);
        userService.insertUser();
    }


}