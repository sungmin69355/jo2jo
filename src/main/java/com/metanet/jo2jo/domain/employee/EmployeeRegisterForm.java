package com.metanet.jo2jo.domain.employee;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EmployeeRegisterForm {
    private  Long posno;
    @NotBlank(message = "아이디를 입력해주세요")
    private  String empname;
    @Email(message = "이메일 형식을 확인해주세요")
    private  String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "전화번호를 정확히 입력해주세요")
    private  String phone;
    private  String address;
    private  String photoaddr;
    @Pattern(regexp = "^\\d{6}\\-[1-4]\\d{6}",message = "주민번호를 정확히 입력해주세요")
    private  String regno;
    private  Long annual;
    private  String id;
    private  String password;
    private  Long salary;
    private  String hiredate;
    private  String academic;
    private  Long military;
    private  Long gender;
}
