package com.jd58.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yht on 2018/12/15.
 */
public class CircularityA {

    @Autowired
    private CircularityB circularityB;

    @Override
    public String toString() {
        return "CircularityA{" +
                "circularityB=" + circularityB +
                '}';
    }
}