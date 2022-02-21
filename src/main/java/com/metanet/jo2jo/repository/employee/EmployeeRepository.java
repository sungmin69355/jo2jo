package com.metanet.jo2jo.repository.employee;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeUpdateForm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EmployeeRepository {
    EmployeeDto findByLoginId(LoginDto loginDto);	
    List<EmployeeSelectDto> selectEmployee(EmployeeSelectDto params);
    Integer insertEmployee(EmployeeRegisterForm employeeRegisterForm);
    Integer updateEmployee(EmployeeUpdateForm employeeUpdateForm);
    List<EmployeeDetailDto> selectEmployeeDetail(EmployeeSelectDto params);
    Integer selectEmployeeTotalCount(EmployeeSelectDto params);
    int idCheck(String id);
    List<EmployeeDto> findByEmployeesRelevantDepartment(Long deptNo);
    Integer deleteEmployee(Long enpno);

}
