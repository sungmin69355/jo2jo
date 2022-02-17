package com.metanet.jo2jo.departmentDelete;

import com.metanet.jo2jo.service.DepartmentDeleteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class DepartmentDeleteServiceTest {
    @Autowired
    private DepartmentDeleteService departmentDeleteService;

    @Test
    @Transactional //자동 rollback
    @DisplayName("해당 부서의 하위 부서가 존재하지 않을 경우 삭제가 가능해야한다.")
    public void DepartmentDeleteTest() {
        //given
        Long DeptNo = 100L; //테스트부서 pk
        Integer DepartmentDeleteResult;
        //when
        DepartmentDeleteResult = departmentDeleteService.deleteDepartment(DeptNo);
        //then
        Assertions.assertThat(DepartmentDeleteResult).isEqualTo(1);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("해당 부서의 하위 부서가 존재할 경우 삭제가 불가능해야한다.")
    public void DepartmentDeleteNoTest() {
        //given
        Long DeptNo = 1006L; //대표이사 pk
        Integer DepartmentDeleteResult;
        //when
        DepartmentDeleteResult = departmentDeleteService.deleteDepartment(DeptNo);
        //then
        Assertions.assertThat(DepartmentDeleteResult).isEqualTo(0);
    }
}
