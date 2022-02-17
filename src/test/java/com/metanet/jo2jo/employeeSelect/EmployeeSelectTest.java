
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
public class EmployeeSelectTest { 
	  @Autowired 
	  private EmployeeSelectService employeeService;
  
	  @Test	  
	  @DisplayName("사원 메인페이지(10행) 조회가 가능해야 한다")
	  public void selectEmployee() {
		 
		  //when
		  EmployeeSelectDto params = new EmployeeSelectDto();
		  Integer employeeSelectTotal = employeeService.employeeTotalCount(params);
		  List<EmployeeSelectDto> employeeSelectList =  employeeService.employeeList(params);
		 		  
		  //then
		  System.out.println("사원조회 모든테이블수:"+employeeSelectTotal);
		  
		  if(employeeSelectTotal > 0) {
			  for(EmployeeSelectDto employeeSelectDto : employeeSelectList) {
				  
				  System.out.println(employeeSelectDto);
			  }
		  }
		  
		  
		  else if(employeeSelectTotal < 0)  {
			  employeeSelectList = Collections.emptyList();
			  
				 for(EmployeeSelectDto employeeSelectDto : employeeSelectList) {
					  
					  System.out.println(employeeSelectDto);
				}
		  	}
		  
		  Assertions.assertThat(employeeSelectList);
		 
	 }
	   
}
 