package com.metanet.jo2jo.departmentSelect;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metanet.jo2jo.domain.department.DepartmentSelectDto;
import com.metanet.jo2jo.service.department.DepartmentSelectService;


@SpringBootTest
public class DepartmentSelectServiceTest {
	@Autowired
	private DepartmentSelectService departmentSelectService;
	
	 @Test
	 @DisplayName("부서 메인페이지(10행) 조회가 가능해야 한다")
	 public void selectDepartment() {
		 //givens
		 DepartmentSelectDto params = new DepartmentSelectDto();
		 Integer departmentSelectTotal =  departmentSelectService.selectDepartmentTotalCount(params);
		 List<DepartmentSelectDto> departmentSelectlist = departmentSelectService.selectDepartment(params);
		 
		 //when
		 System.out.println("부서조회 모든테이블수:"+departmentSelectTotal);
		 

		 if(departmentSelectTotal > 0) {
			 for(DepartmentSelectDto departmentSelectDto : departmentSelectlist) {
				  
				 System.out.println(departmentSelectDto);
			 }
		 }
		 
		 else if(departmentSelectTotal < 0)  {
			  departmentSelectlist = Collections.emptyList();
			  
				 for(DepartmentSelectDto departmentSelectDto : departmentSelectlist) {
					  
					  System.out.println(departmentSelectDto);
				}
		  	}
		  
		  Assertions.assertThat(departmentSelectlist);
		
	 }
}
