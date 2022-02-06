package com.metanet.jo2jo.domain.Login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {
    @NotBlank(message = "아이디를 입력해주세요")
    @NotNull(message = "아이디를 입력해주세요")
    private  String id;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @NotNull(message = "비밀번호를 입력해주세요")
    private  String password;
}