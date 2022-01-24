package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/register")
    String register(){
        return "employee/employee-register";
    }

    @GetMapping("/index")
    String index() {
        return "index";
    }

    }
