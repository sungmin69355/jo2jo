package com.metanet.jo2jo.departmentRegister;

import com.metanet.jo2jo.domain.department.DepartmentDetailDto;
import com.metanet.jo2jo.service.DepartmentDetailService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentDetailServiceTest {
    @Autowired
    private DepartmentDetailService departmentDetailService;

    @Test
    @DisplayName("부서 상세조회가 가능해야한다.")
    public void DepartmentDetailTest() {
        //given
        Long deptNo = 1006L;
        //when
        DepartmentDetailDto departmentDetailDto  = departmentDetailService.selectDepartment(deptNo);
        //then
        Assertions.assertThat(departmentDetailDto.getDeptno()).isEqualTo(1006L);
    }

    @Test
    @DisplayName("부서정보가 없는 pk로 조회가 불가능해야한다.")
    public void DepartmentDetailNoPkTest() {
        //given
        Long deptNo = 10000000L;
        //when
        DepartmentDetailDto departmentDetailDto  = departmentDetailService.selectDepartment(deptNo);
        //then
        Assertions.assertThat(departmentDetailDto).isEqualTo(null);
    }
}
