package com.metanet.jo2jo.repository.department;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.department.DepartmentForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentRepository {
    List<DepartmentDto> findAllByDepartment();
    Integer insertDepartment(DepartmentForm departmentForm);
}
