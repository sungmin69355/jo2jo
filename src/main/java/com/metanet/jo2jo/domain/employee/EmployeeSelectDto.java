package com.metanet.jo2jo.domain.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
public class EmployeeSelectDto {
	
	private String empname2;
	private String deptname2;
	private String phone2;
	private Long annual2;
    private String email2;
    private String regno2;
	
    public EmployeeSelectDto(String empname2, String deptname2, String phone2, Long annual2, String email2,String regno2) {		
		this.empname2 = empname2;
		this.deptname2 = deptname2;
		this.phone2 = phone2;
		this.annual2 = annual2;
		this.email2 = email2;
		this.regno2 = regno2;
	}
 
      	
}
