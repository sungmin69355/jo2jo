package com.metanet.jo2jo.service.employee;

import com.metanet.jo2jo.repository.Educated.EducatedRepository;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeDeleteService {
    private final EducatedRepository educatedRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    //사원삭제
    public Integer deleteEmployee(Long empno){
        return employeeRepository.deleteEmployee(empno);
    }
    //커리큘럼삭제
    public Integer deleteEmployeeEducated(Long empno){
        return educatedRepository.deleteEmployeeEducated(empno);
    }
    //부서 매니저정보 있으면 삭제
    public Integer deleteManagerDepartment(Long empno){
        return departmentRepository.deleteManagerDepartment(empno);
    }

}
