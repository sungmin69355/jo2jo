package com.metanet.jo2jo.domain.department;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmnetSelectDto {
	
	private Long deptno;
    private String deptname;
    private String manager;

}
