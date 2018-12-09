package com.jd58.test;

import com.jd58.tx.TxConfig;
import com.jd58.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestTx {
    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);

    @Test
    public void test01() {
        UserService userService = ac.getBean(UserService.class);
        userService.insertUser();
    }


}