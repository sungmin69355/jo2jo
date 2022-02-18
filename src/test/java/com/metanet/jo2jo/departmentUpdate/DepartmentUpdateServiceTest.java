package com.metanet.jo2jo.departmentUpdate;

import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.DepartmentUpdateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class DepartmentUpdateServiceTest {
    @Autowired
    private DepartmentUpdateService departmentUpdateService;

    @Test
    @Transactional //자동 rollback
    @DisplayName("관리자는 해당 부서가 있는 경우 부서 정보를 업데이트 할 수 있어야 한다.")
    public void DepartmentUpdateTest(){
        //given
        Long deptNo = 1006L;
        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setDeptno(1006L);
        departmentForm.setDeptname("테스트");
        departmentForm.setManager(null);
        departmentForm.setDeptpid(null);
        //when
        Integer DepartmentUpdateResult = departmentUpdateService.updateDepartment(departmentForm);
        //then
        Assertions.assertThat(DepartmentUpdateResult).isEqualTo(1);

    }
    @Test
    @Transactional //자동 rollback
    @DisplayName("관리자는 해당 부서가 없을 경우 부서 정보를 업데이트 할 수 없어야 한다.")
    public void DepartmentNotUpdateTest(){
        //given
        Long deptNo = 100000L; //없는 부서
        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setDeptno(100000L);
        departmentForm.setDeptname("테스트");
        departmentForm.setManager(null);
        departmentForm.setDeptpid(null);
        //when
        Integer DepartmentUpdateResult = departmentUpdateService.updateDepartment(departmentForm);
        //then
        Assertions.assertThat(DepartmentUpdateResult).isEqualTo(0);

    }
    @Test
    @Transactional //자동 rollback
    @DisplayName("관리자는 부서장을 지정하기위해 해당 부서의 직원들을 조회할 수 있어야한다.")
    public void findByEmployeesRelevantDepartmentTest(){
        //given
        Long deptNo = 1000L;
        //when
        List<EmployeeDto> findByEmployeesRelevantDepartment = departmentUpdateService.findByEmployeesRelevantDepartment(deptNo);
        //then
        Assertions.assertThat(findByEmployeesRelevantDepartment.size()).isGreaterThan(0);

    }
}
