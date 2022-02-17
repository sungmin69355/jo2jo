package com.metanet.jo2jo.service;


import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.commons.PaginationInfo;
import com.metanet.jo2jo.domain.department.DepartmentSelectDto;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentSelectService {
	
	private final DepartmentRepository departmentRepository;
	
	//부서조회 총 개수
	 public Integer selectDepartmentTotalCount(DepartmentSelectDto params) {
		 return departmentRepository.selectDepartmentTotalCount(params);
	 }
	
	//부서조회 페이지
	public List<DepartmentSelectDto> selectDepartment(DepartmentSelectDto params) {
		List<DepartmentSelectDto> emptydepartmentlist = Collections.emptyList();
		int departmentTotalcount = departmentRepository.selectDepartmentTotalCount(params);
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(departmentTotalcount);
		params.setPaginationInfo(paginationInfo);
		
		if(departmentTotalcount > 0) {
			return departmentRepository.selectDepartment(params);
		}
		else {
			return emptydepartmentlist;
		}
	}
	
	
}
