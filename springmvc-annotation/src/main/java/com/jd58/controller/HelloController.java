package com.jd58.controller;

import com.jd58.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yht on 2018/12/11.
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        String hello = helloService.sayHello("tomcat");
        return hello;
    }

    @RequestMapping("/suc")
    public String success() {
        return "success";
    }
}