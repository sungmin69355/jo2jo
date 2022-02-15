package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentRegisterService {
    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> findAllByDepartment() {
        return departmentRepository.findAllByDepartment();
    };

    public Integer insertDepartment(DepartmentForm departmentForm){
        return departmentRepository.insertDepartment(departmentForm);
    }
}
