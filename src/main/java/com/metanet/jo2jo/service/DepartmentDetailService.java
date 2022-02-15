package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.department.DepartmentDetailDto;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentDetailService {
    private final DepartmentRepository departmentRepository;

    public DepartmentDetailDto selectDepartment(Long deptNo){
      return departmentRepository.findOneByDepartment(deptNo);
    };

}
