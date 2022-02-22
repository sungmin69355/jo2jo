package com.metanet.jo2jo.educated.educatedSelect;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metanet.jo2jo.domain.educated.EducatedSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.service.educated.EducatedSelectService;

@SpringBootTest 
public class EducatedSelectServiceTest {
	   @Autowired
	   private EducatedSelectService educatedSelectService;
	   
	   @Test	  
	   @DisplayName("교육이수 메인페이지(10행) 조회가 가능해야 한다")
	   public void selectEducated() {
		   
		 //when
		 EmployeeDetailDto employeeDetailDto = new EmployeeDetailDto();
		 EducatedSelectDto educatedSelectDto = new EducatedSelectDto();
		 employeeDetailDto.setEmpno(673L);
		 System.out.println("현재 교육이수중인 사원번호:"+ employeeDetailDto.getEmpno());
		 Integer educatedTotalCount = educatedSelectService.selectEducatedTotalCount(employeeDetailDto);
		 List<EducatedSelectDto> educatedlist = educatedSelectService.selectEducated(employeeDetailDto);
		 
		 //then
		 System.out.println("교육이수조회 모든테이블수:"+ educatedTotalCount);
		
		if(educatedTotalCount > 0) {
			  educatedSelectDto.setEmpno(employeeDetailDto.getEmpno());
			  for(EducatedSelectDto educatedSelect: educatedlist) {
				  
				  System.out.println(educatedSelect);
			  }
		}
		
		else if(educatedTotalCount < 0)  {
				educatedlist = Collections.emptyList();
			  
				 for(EducatedSelectDto educatedSelectDto2 : educatedlist) {
					  
					  System.out.println(educatedSelectDto2);
				}
		  	}
		  
		  Assertions.assertThat(educatedlist);
		 
	 }
	   
	   
}
