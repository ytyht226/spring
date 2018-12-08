package com.jd58.test;

import com.jd58.bean.Boss;
import com.jd58.bean.Car;
import com.jd58.config.MainConfigAutowired;
import com.jd58.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yanghuitao on 2018/12/7.
 */
public class IocTestAutowired {
    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigAutowired.class);



    @Test
    public void test01() {
        BookService bookService = ac.getBean("bookService", BookService.class);
        System.out.println(bookService);

//        BookDao bookDao = ac.getBean(BookDao.class);
//        System.out.println(bookDao);

        Boss boss = ac.getBean(Boss.class);
        System.out.println(boss);
        Car car = ac.getBean(Car.class);
        System.out.println(car);
        ac.close();
    }


}