package com.metanet.jo2jo.login;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.service.LoginService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    @DisplayName("관리자는 로그인이 가능해야한다.")
    public void adminLoginTest(){
        //given
        LoginDto loginDto = new LoginDto();
        loginDto.setId("whtjdals");
        loginDto.setPassword("1234");

        //when
        AdminDto adminDto = loginService.adminFindByLoginId(loginDto);
        System.out.println(adminDto.getId());
        //then
        Assertions.assertThat(loginDto.getId()).isEqualTo(adminDto.getId());
    }

    @Test
    @DisplayName("관리자는 계정이 없을경우 로그인 X")
    public void adminNotLoginTest(){
        //given
        LoginDto loginDto = new LoginDto();
        loginDto.setId("test");
        loginDto.setPassword("1234");

        //when
        AdminDto adminDto = loginService.adminFindByLoginId(loginDto);
        //then
        Assertions.assertThat(adminDto).isEqualTo(null);
    }
    @Test
    @DisplayName("관리자 login input값이 null일 경우 NullPointerException")
    public void adminLoginInputNullTest(){
        //given
        LoginDto loginDto = new LoginDto();
        loginDto.setId(" ");
        loginDto.setPassword(" ");

        //when
        AdminDto adminDto = loginService.adminFindByLoginId(loginDto);

        //then
        assertThrows(NullPointerException.class, () -> {
            Assertions.assertThat(adminDto.getId()).isEqualTo(loginDto.getId());
        });
    }


    @Test()
    @DisplayName("관리자가 비밀번호나 아이디의 입력값이 없을경우 MyBatisSystemException")
    public  void adminNotLoginDtoTest() {
        //given
        LoginDto loginDto = new LoginDto();

        //when
        // AdminDto adminDto = loginService.adminFindByLoginId(loginDto);

        //then
        assertThrows(MyBatisSystemException.class, () -> {
            AdminDto adminDto = loginService.adminFindByLoginId(loginDto);
        });
    }


}
