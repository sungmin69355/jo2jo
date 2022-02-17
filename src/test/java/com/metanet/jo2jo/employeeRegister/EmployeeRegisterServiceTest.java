package com.metanet.jo2jo.employeeRegister;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.EmployeeRegisterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EmployeeRegisterServiceTest {
    @Autowired
    private EmployeeRegisterService employeeRegisterService;

    @Test
    @DisplayName("사원등록 폼 호출 시 부서 정보가 같이 넘어가야 한다.")
    public void findAllDepartmentTest() {
        //given
        List<DepartmentDto> findByAllDepartment;
        //when
        findByAllDepartment = employeeRegisterService.findAllByDepartment();
        //then
        Assertions.assertThat(findByAllDepartment);

    }

    @Test
    @DisplayName("사원등록 폼 호출 시 직급 정보가 같이 넘어가야 한다.")
    public void findAllPositionTest() {
        //given
        List<PositionDto> findAllByPosition;
        //when
        findAllByPosition = employeeRegisterService.findAllByPosition();
        //then
        Assertions.assertThat(findAllByPosition);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원 등록이 가능해야한다.")
    public void insertEmployeeTest() {
        //given
        EmployeeRegisterForm employeeRegisterForm = new EmployeeRegisterForm(
                10001L, 1011L, "조성민", "test@naver.com", "010-0000-0000", "서울특별시 강동구 길동 40-10 ~ ",
                "/images/user/aaa.jpg", "000000-1000000", Long.valueOf(1), "employeeTestId", "1234", Long.valueOf(100000000),
                "2022-02-03", "1", Long.valueOf(0), Long.valueOf(2)
        );

        //when
        Integer insertEmployeeResult = employeeRegisterService.insertEmployee(employeeRegisterForm);

        //then
        assertTrue(insertEmployeeResult == null);
    }


}
