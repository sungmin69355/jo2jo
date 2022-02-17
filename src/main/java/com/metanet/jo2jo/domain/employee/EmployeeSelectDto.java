package com.metanet.jo2jo.domain.employee;

import com.metanet.jo2jo.domain.commons.CommonDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeSelectDto extends CommonDto{	
	private Long rn;
	private String empname;
	private String deptname;
	private String phone;
	private Long annual;
    private String email;
    private Long empno;
    private String id;
   
    
    	
	public EmployeeSelectDto(Long rn, String empname, String deptname, String phone, Long annual,String email, Long empno,String id) {	
		this.rn = rn;
		this.empname = empname;
		this.deptname = deptname;
		this.phone = phone;
		this.annual = annual;
		this.email = email;
		this.empno = empno;
		this.id = id;
	}



	
  
	
    
 
      	
}
