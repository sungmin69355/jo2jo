package com.metanet.jo2jo.repository.Educated;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.jo2jo.domain.educated.EducatedSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;

@Repository
@Mapper
public interface EducatedRepository {
	 List<EducatedSelectDto> selectEducated(EmployeeDetailDto employeeDetailDto);
	 Integer selectEducatedTotalCount(EmployeeDetailDto employeeDetailDto);
}
