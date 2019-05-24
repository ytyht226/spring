package com.jd58.mvcxml.wrapper;

import lombok.Data;

/**
 * Created by yanghuitao on 2019/5/24.
 */
@Data
public class Car {
    private String name;
    private Wheel[] wheels;

    private Driver driver;
}