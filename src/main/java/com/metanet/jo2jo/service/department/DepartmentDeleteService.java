package com.metanet.jo2jo.service.department;

import com.metanet.jo2jo.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentDeleteService {
    private final DepartmentRepository departmentRepository;

    public Integer deleteDepartment(Long deptNo){
        return departmentRepository.deleteDepartment(deptNo);
    };
}
