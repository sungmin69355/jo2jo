package com.metanet.jo2jo.EmployeeRegister;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.EmployeeRegisterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
}
