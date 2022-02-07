package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	/*
	 * //사원조회
	 * 
	 * @GetMapping("/employee") String employeeMain(Model model) {
	 * model.addAttribute("employeelist1",employeeService.employeelist()); return
	 * "employee/employee-main"; }
	 */
    
  //사원조회 부서추가
    @GetMapping("/employee")
     String employeeMain(Model model) {    	
    	model.addAttribute("employeelist", employeeService.employeelist());
        return "employee/employee-main";
       
    }
}
