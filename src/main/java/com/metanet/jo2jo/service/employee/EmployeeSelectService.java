package com.metanet.jo2jo.service.employee;


import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.commons.PaginationInfo;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.repository.administrator.AdminRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeSelectService {
	 private final EmployeeRepository employeeRepository;
	

	
	 public Integer employeeTotalCount(EmployeeSelectDto params) {
		 return employeeRepository.selectEmployeeTotalCount(params);
	 }
	 
	 //사원조회 페이지
	 public List<EmployeeSelectDto> employeeList(EmployeeSelectDto params) {
		 
		 //list가 비어있을때를 고려하기 위해 빈 리스트 생성
		 List<EmployeeSelectDto> emptyployeeList = Collections.emptyList();
		 int employeeTotalCount = employeeRepository.selectEmployeeTotalCount(params);
		 PaginationInfo paginationInfo = new PaginationInfo(params);
		 paginationInfo.setTotalRecordCount(employeeTotalCount);
		 
		 params.setPaginationInfo(paginationInfo);
		 
		 if(employeeTotalCount > 0) {
			 return employeeRepository.selectEmployee(params);
		 }
		 else {
			 return emptyployeeList;
		 }
		 
		
	 }
	 //사원조회 상세페이지
	 public List<EmployeeDetailDto> employeeDetailList(EmployeeSelectDto params) {
		 return employeeRepository.selectEmployeeDetail(params);
	 }
	 
}
