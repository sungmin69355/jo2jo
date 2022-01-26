package com.metanet.jo2jo.login;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.service.LoginService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;



    @Test
    @DisplayName("관리자는 로그인이 가능해야한다.")
    public void loginTest(){
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
}
