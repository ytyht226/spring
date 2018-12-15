package com.jd58.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yht on 2018/12/15.
 */
public class CircularityB {

    @Autowired
    private CircularityA circularityA;

}