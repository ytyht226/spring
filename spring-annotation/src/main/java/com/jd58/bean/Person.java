package com.jd58.bean;

import lombok.Data;

/**
 * Created by yht on 2018/12/6.
 */
@Data
public class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}