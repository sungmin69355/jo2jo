package com.metanet.jo2jo.domain.employee;

import com.metanet.jo2jo.domain.commons.CommonDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDetailDto extends CommonDto {
	private String empname;
	private String deptname;
	private String posname;
	private Long annual;
	private String phone;
	private String address;
	private String photoaddr;
	private String email;
	private String hiredate;
	private String regno;
	private String id;
	private String password;
	private Long salary;
	private String academic;
	private Long military;
	private Long gender;
	private Long empno;
	
}
