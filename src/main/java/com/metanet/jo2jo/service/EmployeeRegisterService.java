package com.metanet.jo2jo.service;


import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import com.metanet.jo2jo.repository.position.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeRegisterService {
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;


    public List<DepartmentDto> findAllByDepartment() {
        return departmentRepository.findAllByDepartment();
    };

    public List<PositionDto> findAllByPosition(){
        return positionRepository.findAllByPosition();
    }



}
