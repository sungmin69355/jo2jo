package com.metanet.jo2jo.department.departmentRegister;


import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.service.department.DepartmentRegisterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class DepartmentRegisterServiceTest {
    @Autowired
    private DepartmentRegisterService departmentRegisterService;

    @Test
    @Transactional //자동 rollback
    @DisplayName("관리자는 상위부서가 없는 부서를 등록할 수 있어야 한다.")
    public void DepartmentInsertTest() {
        //given
        DepartmentForm departmentForm = new DepartmentForm();
        //when
        departmentForm.setDeptname("지원실");
        departmentForm.setDeptpid(null);
        Integer departmentRegisterResult =departmentRegisterService.insertDepartment(departmentForm);
        //then
        Assertions.assertThat(departmentRegisterResult).isEqualTo(1);

    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("관리자는 상위부서가 있는 부서를 등록할 수 있어야 한다.")
    public void DepartmentInsertByDeptPidTest() {
        //given
        DepartmentForm departmentForm = new DepartmentForm();
        //when
        departmentForm.setDeptname("지원실");
        departmentForm.setDeptpid(1L);
        Integer departmentRegisterResult =departmentRegisterService.insertDepartment(departmentForm);
        //then
        Assertions.assertThat(departmentRegisterResult).isEqualTo(1);

    }
}
