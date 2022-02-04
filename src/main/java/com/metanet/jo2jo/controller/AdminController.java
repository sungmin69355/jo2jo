package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/register")
    String employeeRegister(HttpSession session){
        return "/employee/employee-register";
    }
  

 }
