package com.metanet.jo2jo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.repository.administrator.AdminRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	 private final AdminRepository adminRepository;
	 private final EmployeeRepository employeeRepository;
	 
		/*
		 * public List<EmployeeDto> employeelist2() { return
		 * employeeRepository.selectEmployee2(); }
		 */
	 
	 public List<EmployeeSelectDto> employeelist() {
	
		 return employeeRepository.selectEmployee();
		
	 }
	 
}
