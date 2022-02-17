
 package com.metanet.jo2jo.employeeSelect;
 
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.EmployeeSelectService;
  
  
@SpringBootTest 
public class SelectEmployeeTest { 
	  @Autowired 
	  private EmployeeSelectService employeeService;
  
	  @Test	  
	  @DisplayName("관리자와 사원은 사원조회가 가능하다.")
	  public void selectEmployee(EmployeeSelectDto params) {
		 
		  //when	
		  Integer employeeSelectTotal = employeeService.employeeTotalCount(params);
		  List<EmployeeSelectDto> employeeSelectList =  employeeService.employeeList(params);
		 		  
		  //then
		  System.out.println("사원조회 모든테이블수:"+employeeSelectTotal);
		  
		  if(employeeSelectTotal > 0) {
			  for(EmployeeSelectDto employeeSelectDto : employeeSelectList) {
				  
				  System.out.println(employeeSelectDto);
			  }
		  }
		  
		  
		  else if(employeeSelectTotal == 0)  {
			  employeeSelectList = Collections.emptyList();
			  
				 for(EmployeeSelectDto employeeSelectDto : employeeSelectList) {
					  
					  System.out.println(employeeSelectDto);
				}
		  	}
		  
		  Assertions.assertThat(employeeSelectList);
		 
	 }
	   
}
 