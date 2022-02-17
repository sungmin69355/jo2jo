
 package com.metanet.jo2jo.employee;
  
 
  
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
	  private EmployeeSelectService employeeSelectService;
  
	  @Test
	  @DisplayName("관리자와 사원은 사원조회가 가능하다.")
	  void selectEmployee() {
		  //when		
		  EmployeeSelectDto params = new EmployeeSelectDto(null, null, null, null, null, null, null);
		  Integer empolyeeTotalCount = employeeSelectService.employeeTotalCount(params);
		  List<EmployeeSelectDto> list = employeeSelectService.employeeList(params);
		  //then
		  System.out.println("사원조회 모든테이블수:"+empolyeeTotalCount);
		  for(EmployeeSelectDto employeeSelectDto : list) {
			  
			  System.out.println(employeeSelectDto);
		  }
		  Assertions.assertThat(list);
		  
		 
		 }
 
}
 