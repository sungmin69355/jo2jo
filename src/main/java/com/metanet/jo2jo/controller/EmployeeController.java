package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
    
	//사원조회 부서추가
    @GetMapping("/employees")
     String employeeMain(@ModelAttribute("params") EmployeeSelectDto params, Model model) {    	
    	model.addAttribute("employeelist", employeeService.employeelist(params));
        return "employee/employee-main";
       
    }
    
  //사원조회 상세페이지
    @GetMapping("/employeedetail")
     String employeeDetail(@ModelAttribute("params") EmployeeSelectDto params, Model model) {    	
    	model.addAttribute("employeedetaillist", employeeService.employeeDetaillist(params));
        return "employee/employee-detail";
       
    }
}
