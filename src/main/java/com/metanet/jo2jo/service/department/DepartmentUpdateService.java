package com.metanet.jo2jo.service.department;

import com.metanet.jo2jo.domain.department.DepartmentDetailDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentUpdateService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentDetailDto selectDepartment(Long deptNo){
        return departmentRepository.findOneByDepartment(deptNo);
    };
    public Integer updateDepartment(DepartmentForm departmentForm){
        return departmentRepository.updateDepartment(departmentForm);
    }
    public List<DepartmentDto> findAllByDepartment() {
        return departmentRepository.findAllByDepartment();
    };

    public List<EmployeeDto> findByEmployeesRelevantDepartment(Long deptNo){
        return employeeRepository.findByEmployeesRelevantDepartment(deptNo);
    }
}
