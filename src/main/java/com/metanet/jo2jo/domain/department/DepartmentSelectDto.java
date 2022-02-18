package com.metanet.jo2jo.domain.department;

import com.metanet.jo2jo.domain.commons.CommonDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentSelectDto extends CommonDto {	
	private Long deptno;
	private Long rn;
    private String deptname;
    private String manager;
}
