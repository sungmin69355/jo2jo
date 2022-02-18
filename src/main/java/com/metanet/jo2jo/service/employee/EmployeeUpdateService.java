package com.metanet.jo2jo.service.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.employee.EmployeeUpdateForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;
import com.metanet.jo2jo.repository.position.PositionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeUpdateService {
	
	 private final DepartmentRepository departmentRepository;
	 private final PositionRepository positionRepository;
	 private final EmployeeRepository employeeRepository;

	 public List<DepartmentDto> findAllByDepartment() {
	      return departmentRepository.findAllByDepartment();
	 };

	 public List<PositionDto> findAllByPosition(){
	      return positionRepository.findAllByPosition();
	 }

	 public Integer updateEmployee(EmployeeUpdateForm employeeUpdateForm) {
	      return employeeRepository.updateEmployee(employeeUpdateForm);
	 }

}
