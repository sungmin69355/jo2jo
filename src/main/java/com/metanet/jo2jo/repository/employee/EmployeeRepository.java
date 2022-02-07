package com.metanet.jo2jo.repository.employee;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EmployeeRepository {
    EmployeeDto findByLoginId(LoginDto loginDto);

	/* List<EmployeeDto> selectEmployee2(); */
    List<EmployeeSelectDto> selectEmployee();
}
