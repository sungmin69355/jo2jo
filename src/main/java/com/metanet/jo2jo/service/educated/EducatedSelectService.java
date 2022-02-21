package com.metanet.jo2jo.service.educated;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.commons.PaginationInfo;
import com.metanet.jo2jo.domain.educated.EducatedSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.repository.Educated.EducatedRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducatedSelectService {
	private final EducatedRepository educatedRepository;
	
	public List<EducatedSelectDto> selectEducated(EmployeeDetailDto employeeDetailDto) {
		 //list가 비어있을때를 고려하기 위해 빈 리스트 생성
		List<EducatedSelectDto>  emptyEducatedlist = Collections.emptyList();
		int educatedTotalCount = educatedRepository.selectEducatedTotalCount(employeeDetailDto);
		PaginationInfo paginationInfo = new PaginationInfo(employeeDetailDto);
		paginationInfo.setTotalRecordCount(educatedTotalCount);
		
		employeeDetailDto.setPaginationInfo(paginationInfo);
		
		if(educatedTotalCount > 0) {
			return educatedRepository.selectEducated(employeeDetailDto);
		}
		else {
			return emptyEducatedlist;
		}
		
	}
	
	 public Integer selectEducatedTotalCount(EmployeeDetailDto employeeDetailDto) {
		 
		 return educatedRepository.selectEducatedTotalCount(employeeDetailDto);
	 }

}
