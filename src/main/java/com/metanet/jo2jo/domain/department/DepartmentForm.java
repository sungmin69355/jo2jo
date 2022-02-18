package com.metanet.jo2jo.domain.department;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class DepartmentForm {
    private Long deptno;
    @NotBlank(message = "공백은 입력할 수 없습니다.")
    private String deptname;
    private String manager;
    private Long deptpid;

    public DepartmentForm(){
    }
}
