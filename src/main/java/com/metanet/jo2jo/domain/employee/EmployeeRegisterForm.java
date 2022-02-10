package com.metanet.jo2jo.domain.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class EmployeeRegisterForm {
    @NotNull(message = "직급을 선택해주세요")
    private  Long posno;
    @NotNull(message = "부서를 선택해주세요")
    private  Long deptno;
    @NotBlank(message = "이름을 입력해주세요")
    private  String empname;
    @Email(message = "이메일 형식을 확인해주세요")
    @NotBlank(message = "이메일을 입력해주세요")
    private  String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "전화번호를 정확히 입력해주세요")
    private  String phone;
    @NotBlank(message = "주소를 입력해주세요")
    private  String address;
    private  String photoaddr;
    @Pattern(regexp = "^\\d{6}\\-[1-4]\\d{6}",message = "주민번호를 정확히 입력해주세요")
    private  String regno;
    private  Long annual;
    @NotBlank(message = "아이디를 입력해주세요")
    private  String id;
    @NotBlank(message = "패스워드를 입력해주세요")
    private  String password;
    @NotNull(message = "연봉을 입력해주세요")
    private  Long salary;
    @NotBlank(message = "입사일을 지정해주세요")
    private  String hiredate;
    @NotBlank(message = "학력을 입력해주세요")
    private  String academic;
    @NotNull(message = "병역을 선택해주세요")
    private  Long military;
    @NotNull(message = "성별을 선택해주세요")
    private  Long gender;
}
