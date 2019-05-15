package com.jd58.mvcxml.controller;

import com.jd58.mvcxml.service.IDeptService;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


@Controller
@RequestMapping("/")
public class IndexController implements EnvironmentAware {

    @Resource
    private IDeptService deptService;
//    @Autowired
//    private MultiService multiServiceDemo1;

    @RequestMapping(value = {"/", "index"})
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
//        view.addObject("welcome", "hello");
        System.out.println(deptService.listAll());
        return view;
    }

    private Environment environment;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}