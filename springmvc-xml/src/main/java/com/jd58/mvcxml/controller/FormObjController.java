package com.jd58.mvcxml.controller;

import com.jd58.mvcxml.model.Dept;
import com.jd58.mvcxml.model.Employee;
import com.jd58.mvcxml.resolver.FormObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yanghuitao on 2018/8/27.
 */
@Controller
@RequestMapping(value = "/foc")
public class FormObjController {
    @RequestMapping("/test1")
    public String test1(@FormObj Dept dept, @FormObj Employee emp) {
        return "index";
    }

    @RequestMapping("/test2")
    public String test2(@FormObj("d") Dept dept, @FormObj("e") Employee emp) {
        return "index";
    }

    @RequestMapping("/test3")
    public String test3(@FormObj(value = "d", show = false) Dept dept, @FormObj("e") Employee emp) {
        return "index";
    }
}