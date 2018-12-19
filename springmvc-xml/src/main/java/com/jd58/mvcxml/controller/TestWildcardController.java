package com.jd58.mvcxml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanghuitao on 2018/12/19.
 */
@Controller
@RequestMapping(value = "/wildcard")
public class TestWildcardController {

    @RequestMapping("/test/**")
    public ModelAndView test1(ModelAndView view) {
        view.setViewName("test");
        view.addObject("attr", "TestWildcardController -> /test/**");
        return view;
    }

    @RequestMapping("/test/*")
    public ModelAndView test2(ModelAndView view) {
        view.setViewName("test");
        view.addObject("attr", "TestWildcardController -> /test*");
        return view;
    }

    @RequestMapping("test?")
    public ModelAndView test3(ModelAndView view) {
        view.setViewName("test");
        view.addObject("attr", "TestWildcardController -> test?");
        return view;
    }

}