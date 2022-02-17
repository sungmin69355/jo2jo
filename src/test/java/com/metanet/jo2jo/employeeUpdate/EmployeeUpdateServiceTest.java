package com.metanet.jo2jo.employeeUpdate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeUpdateForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.EmployeeUpdateService;

@SpringBootTest
public class EmployeeUpdateServiceTest {
	@Autowired
	private EmployeeUpdateService employeeUpdateService;
	
	@Test
	@DisplayName("사원수정 폼 호출시 부서 정보가 같이 넘어가야 한다.")
	 public void findAllDepartmentTest() {
	     //given
	     List<DepartmentDto> findByAllDepartment;
	     //when
	     findByAllDepartment = employeeUpdateService.findAllByDepartment();
	     //then
	     Assertions.assertThat(findByAllDepartment);

    }
	
	 @Test
	 @DisplayName("사원수정 폼 호출 시 직급 정보가 같이 넘어가야 한다.")
	  public void findAllPositionTest() {
	      //given
	      List<PositionDto> findAllByPosition;
	      //when
	      findAllByPosition = employeeUpdateService.findAllByPosition();
	      //then
	      Assertions.assertThat(findAllByPosition);
	 }
	 
	 @Test
	 @Transactional //자동 rollback
	 @DisplayName("사원 수정이 가능해야한다.")
	 public void updateEmployeeTest() {
		 //given
//		 EmployeeUpdateForm employeeUpdateForm = new EmployeeUpdateForm(1003L,1004L, 10005L, "조민국", 
//				 "jo@example.com", "010-3333-7777", "고양", "c83ffe1b-63b3-4bda-b8d3-e5c84a4eed44.jpg", 
//				 null, null, "test6000","1234",8000L , "2022-03-07", Long.valueOf(1), Long.valueOf(1));
		 EmployeeUpdateForm employeeUpdateForm = new EmployeeUpdateForm(
				 1003L,1004L, 10005L,"jo@example.com", "010-3333-7777", "고양", 
				 "c83ffe1b-63b3-4bda-b8d3-e5c84a4eed44.jpg", "930104-1011111", Long.valueOf(1), 
				"test6000", "1234", 8000L, "2022-02-03", "2" ,Long.valueOf(1),Long.valueOf(1)
		 );
		 
		 //when
	     Integer updateEmployeeResult = employeeUpdateService.updateEmployee(employeeUpdateForm);

	     //then
	     assertTrue(updateEmployeeResult == null);
			 
		 
	 }
}
