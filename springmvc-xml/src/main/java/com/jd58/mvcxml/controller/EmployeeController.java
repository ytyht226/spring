package com.jd58.mvcxml.controller;

import com.jd58.mvcxml.model.Employee;
import com.jd58.mvcxml.service.IDeptService;
import com.jd58.mvcxml.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDeptService deptService;

    @RequestMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("employee/list");
        List<Employee> employees = employeeService.list();
        view.addObject("list", employees);
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{employeeId}")
    @ResponseBody
    public String delete(@PathVariable Integer employeeId) {
        employeeService.delete(employeeId);
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public ModelAndView add(ModelAndView view) {
        view.setViewName("employee/form");
        view.addObject("depts", deptService.listAll());
        return view;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail/{employeeId}")
    public ModelAndView detail(@PathVariable Integer employeeId, ModelAndView view) {
        view.setViewName("employee/form");
        view.addObject("employee", employeeService.getById(employeeId));
        view.addObject("depts", deptService.listAll());
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String add(Employee employee) {
        if(employee.getDept().getId() == null) {
            employee.setDept(null);
        }
        employeeService.saveOrUpdate(employee);
        return "redirect:/employee/";
    }

    @RequestMapping("/xmlOrJson")
    @ResponseBody
    public Map<String, Object> xmlOrJson(@RequestBody Employee e) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setAge(1);
        e1.setId(1);
        e1.setName("e1");

        Employee e2 = new Employee();
        e2.setAge(2);
        e2.setId(2);
        e2.setName("e2");
        list.add(e1);
        list.add(e2);
        map.put("list", list);
        return map;
    }

}
