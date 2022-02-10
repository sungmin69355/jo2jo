package com.metanet.jo2jo.domain.employee;

import com.metanet.jo2jo.domain.commons.CommonDto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class EmployeeSelectDto extends CommonDto{	
	private Long rn;
	private String empname;
	private String deptname;
	private String phone;
	private Long annual;
    private String email;
    
    	
	public EmployeeSelectDto(Long rn, String empname, String deptname, String phone, Long annual,String email) {	
		this.rn = rn;
		this.empname = empname;
		this.deptname = deptname;
		this.phone = phone;
		this.annual = annual;
		this.email = email;
	}
  
	@Override
	public String toString() {
		return "EmployeeSelectDto [rn=" + rn + ", empname=" + empname + ", deptname=" + deptname
				+ ", phone=" + phone + ", annual=" + annual + ", email=" + email + "]";
	}
    
 
      	
}
