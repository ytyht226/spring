package com.jd58.mvcxml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanghuitao on 2018/8/29.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = {"/", ""})
    public String index() {
        return "login";
    }

    @RequestMapping("/auth")
    public String auth(@RequestParam String username, HttpServletRequest req) {
        req.getSession().setAttribute("loginUser", username);
        return "redirect:/index";
    }

    @RequestMapping("/out")
    public String out(HttpServletRequest req) {
        req.getSession().removeAttribute("loginUser");
        return "redirect:/login";
    }
}