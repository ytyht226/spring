package com.jd58.bean;

import org.springframework.stereotype.Component;

/**
 * Created by yht on 2018/12/7.
 */
@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car init...");
    }

    public void destroy() {
        System.out.println("car destroy...");
    }
}