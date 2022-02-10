package com.metanet.jo2jo.domain.employee;

import com.metanet.jo2jo.domain.commons.CommonDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSelectDto extends CommonDto{	
	private Long rownum2;
	private String empname2;
	private String deptname2;
	private String phone2;
	private Long annual2;
    private String email2;
    
    	
	public EmployeeSelectDto(Long rownum2, String empname2, String deptname2, String phone2, Long annual2,String email2) {	
		this.rownum2 = rownum2;
		this.empname2 = empname2;
		this.deptname2 = deptname2;
		this.phone2 = phone2;
		this.annual2 = annual2;
		this.email2 = email2;
	}
  
	@Override
	public String toString() {
		return "EmployeeSelectDto [rownum2=" + rownum2 + ", empname2=" + empname2 + ", deptname2=" + deptname2
				+ ", phone2=" + phone2 + ", annual2=" + annual2 + ", email2=" + email2 + "]";
	}
    
 
      	
}
