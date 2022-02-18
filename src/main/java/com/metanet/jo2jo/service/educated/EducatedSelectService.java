package com.metanet.jo2jo.service.educated;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.educated.EducatedSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.repository.Educated.EducatedRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducatedSelectService {
	private final EducatedRepository educatedRepository;
	
	public List<EducatedSelectDto> selectEducated(EmployeeDetailDto employeeDetailDto) {
		
		return educatedRepository.selectEducated(employeeDetailDto);
	}

}
