package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
    
	//사원조회 부서추가
    @GetMapping("/employee")
     String employeeMain(@ModelAttribute("params") EmployeeSelectDto params, Model model) {    	
    	model.addAttribute("employeelist", employeeService.employeelist(params));
        return "employee/employee-main";
       
    }
}
