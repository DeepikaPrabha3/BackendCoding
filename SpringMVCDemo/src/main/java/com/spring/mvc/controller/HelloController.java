package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    public HelloController() {
    }

    @RequestMapping("/greeting")
    public String hellopage(){
        System.out.println("greeting called");
        return "hello";
    }
}
