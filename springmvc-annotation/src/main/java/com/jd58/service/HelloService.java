package com.jd58.service;

import org.springframework.stereotype.Service;

/**
 * Created by yht on 2018/12/11.
 */
@Service
public class HelloService {

    public String sayHello(String name){
        return "Hello " + name;
    }
}