package com.metanet.jo2jo.employee.employeeUpdate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.employee.EmployeeUpdateService;

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
		 

		 EmployeeDetailDto employeeDetailDto  = new EmployeeDetailDto();	 
		 employeeDetailDto.setDeptno(1009L);
		 employeeDetailDto.setPosno(10002L);		
		 employeeDetailDto.setEmpname("조민국");
		 employeeDetailDto.setEmail("test@example.com");		 
		 employeeDetailDto.setPhone("010-2222-8888");
		 employeeDetailDto.setAddress("마포구");
		 employeeDetailDto.setPhotoaddr("/images/user/aaa.jpg");
		 employeeDetailDto.setRegno("000000-1000000");
		 employeeDetailDto.setAnnual(Long.valueOf(1));
		 employeeDetailDto.setId("employeeTestId");
		 employeeDetailDto.setPassword("1234");
		 employeeDetailDto.setSalary(Long.valueOf(100000000));
		 employeeDetailDto.setHiredate("2022-02-03");
		 employeeDetailDto.setAcademic("1");
		 employeeDetailDto.setMilitary(Long.valueOf(0));
		 employeeDetailDto.setGender(Long.valueOf(2));
		 employeeDetailDto.setEmpno(561L);
				 
		 //when
	     Integer updateEmployeeResult = employeeUpdateService.updateEmployee(employeeDetailDto);
	     System.out.println(updateEmployeeResult);

	     //then
	     assertTrue(updateEmployeeResult == 1);
			 
		 
	 }
}
