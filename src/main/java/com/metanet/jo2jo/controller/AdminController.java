package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdminController {

    @GetMapping("/register")
    String employeeRegisterForm(HttpSession session, Model model){
        return "/employee/employee-register";
    }

    @PostMapping("/employee")
    String employeeRegister(HttpSession session, HttpServletRequest request, @Valid EmployeeRegisterForm employeeRegisterForm, BindingResult bindingResult){

        if(session.getAttribute("user").equals("admin")){
            //Valid 검증
            if (bindingResult.hasErrors()) {
                return "/employee/employee-register";
            }
            //insert로직

            //결과
        }else{
            return "/employee/employee-main";
        }

        return "/employee/employee-main";
    }
  

 }
