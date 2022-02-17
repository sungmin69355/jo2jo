package com.metanet.jo2jo.repository.department;


import com.metanet.jo2jo.domain.department.DepartmentDetailDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.domain.department.DepartmentSelectDto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentRepository {
    List<DepartmentDto> findAllByDepartment();
    List<DepartmentDto> findLowestDepartment(); //최하위부서
    Integer insertDepartment(DepartmentForm departmentForm);
    DepartmentDetailDto findOneByDepartment(Long deptNo);
    List<DepartmentSelectDto> selectDepartment(DepartmentSelectDto params);
    Integer selectDepartmentTotalCount(DepartmentSelectDto params);



}
