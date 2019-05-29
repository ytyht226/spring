package com.jd58.mvcxml.test.wrapper;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanghuitao on 2019/5/24.
 */
@Data
public class Car {
    private String name;
    private List<Wheel> wheels;

    private Driver driver;
    private Map<String, Wheel> wheelMap = new HashMap<>();
}