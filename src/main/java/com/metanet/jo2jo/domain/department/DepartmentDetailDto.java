package com.metanet.jo2jo.domain.department;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentDetailDto {
    private Long deptno;
    private String deptname;
    private String manager;
    private String deptpidname;

    public DepartmentDetailDto(){
    }

}
