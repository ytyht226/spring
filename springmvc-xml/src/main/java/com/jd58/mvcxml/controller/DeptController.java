package com.jd58.mvcxml.controller;

import com.jd58.mvcxml.model.Dept;
import com.jd58.mvcxml.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/update")
    @ResponseBody
    public String update(Dept dept) {
        deptService.saveOrUpdate(dept);
        return "success";
    }

}
