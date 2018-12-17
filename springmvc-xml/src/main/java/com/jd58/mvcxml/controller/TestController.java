package com.jd58.mvcxml.controller;

import com.jd58.mvcxml.customeditor.CustomEmployeeEditor;
import com.jd58.mvcxml.model.Employee;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanghuitao on 2018/8/24.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

        binder.registerCustomEditor(Employee.class, new CustomEmployeeEditor());
    }

    @RequestMapping("/testRb")
    @ResponseBody
    public Employee testRb(@RequestBody Employee e) {
        return e;
    }

    @RequestMapping("/testCustomObj")
    @ResponseBody
    public Employee testCustomObj(Employee e) {
        return e;
    }

    @RequestMapping("/testCustomObjWithRp")
    @ResponseBody
    public Employee testCustomObjWithRp(@RequestParam Employee e) {
        return e;
    }

    @RequestMapping("/testDate")
    @ResponseBody
    public Date testDate(Date date) {
        return date;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map test(boolean b) {
        Map map = new HashMap();
        map.put("b", b);
        return map;
    }

    public static void main(String[] args) {
        Map map = new HashMap<>();
        System.out.println(String.class.isAssignableFrom(map.getClass()));
    }
}