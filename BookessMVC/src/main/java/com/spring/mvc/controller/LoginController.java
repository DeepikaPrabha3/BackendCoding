package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    public LoginController() {
    }
    @RequestMapping("/login")
    public String loginUserPage(){
        System.out.println("Login Called");
        return "login";

    }
}
