package com.jd58.mvcxml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanghuitao on 2018/8/30.
 */
@Controller
@RequestMapping(value = "/trvc")
public class TestViewResolverController {
    @RequestMapping("jsp")
    public ModelAndView jsp(ModelAndView view) {
        view.setViewName("jsp:trvc/index");
        return view;
    }

    @RequestMapping("/ftl")
    public ModelAndView freemarker(ModelAndView view) {
        view.setViewName("freemarker:trvc/index");
        return view;
    }
}