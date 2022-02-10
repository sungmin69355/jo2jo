package com.metanet.jo2jo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.commons.PaginationInfo;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.repository.administrator.AdminRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	 private final EmployeeRepository employeeRepository;
	
	 
	
	 public int EmployeeTotalCount(EmployeeSelectDto params) {
		 return employeeRepository.selectEmployeeTotalCount(params);
	 }
	 
	 public List<EmployeeSelectDto> employeelist(EmployeeSelectDto params) {
		 int employeeTotalCount = employeeRepository.selectEmployeeTotalCount(params);
		 PaginationInfo paginationInfo = new PaginationInfo(params);
		 paginationInfo.setTotalRecordCount(employeeTotalCount);
		 
		 params.setPaginationInfo(paginationInfo);
		 
		 if(employeeTotalCount > 0) {
			 return employeeRepository.selectEmployee(params);
		 }
		 else {
			 return employeelist(params);
		 }
		 
		
	 }
	 
}
