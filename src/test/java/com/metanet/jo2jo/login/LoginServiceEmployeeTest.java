package com.metanet.jo2jo.login;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.LoginService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class LoginServiceEmployeeTest {

    @Autowired
    LoginService loginService;

    @Test
    @DisplayName("사원은 로그인이 가능해야한다.")
    public void adminLoginTest(){
        //given
        LoginDto loginDto = new LoginDto();
        loginDto.setId("1003");
        loginDto.setPassword("1234");

        //when
        EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);
        //then
        Assertions.assertThat(loginDto.getId()).isEqualTo(employeeDto.getId());
    }

    @Test
    @DisplayName("사원은 계정이 없을경우 로그인 X")
    public void adminNotLoginTest(){
        //given
        LoginDto loginDto = new LoginDto();
        loginDto.setId("notnull");
        loginDto.setPassword("1234");

        //when
        EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);

        //then
        Assertions.assertThat(employeeDto).isEqualTo(null);
    }
    @Test
    @DisplayName("사원 login input값이 null일 경우 NullPointerException")
    public void adminLoginInputNullTest(){
        //given
        LoginDto loginDto = new LoginDto();
        loginDto.setId(" ");
        loginDto.setPassword(" ");

        //when
        EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);

        //then
        assertThrows(NullPointerException.class, () -> {
            Assertions.assertThat(employeeDto.getId()).isEqualTo(loginDto.getId());
        });
    }


    @Test()
    @DisplayName("사원이 비밀번호나 아이디의 입력값이 없을경우 MyBatisSystemException")
    public  void adminNotLoginDtoTest() {
        //given
        LoginDto loginDto = new LoginDto();

        //when
        //EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);

        //then
        assertThrows(MyBatisSystemException.class, () -> {
            EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);
        });
    }
}
