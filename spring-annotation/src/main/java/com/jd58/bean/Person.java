package com.jd58.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by yht on 2018/12/6.
 */
@Data
public class Person {
    @Value("zhangsan")
    private String name;
    @Value("#{20 - 5}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}