package com.metanet.jo2jo.employee.employeeDelete;

import com.metanet.jo2jo.service.employee.EmployeeDeleteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EmployeeDeleteServiceTest {
    @Autowired
    private EmployeeDeleteService deleteService;

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원삭제시 커리큘럼 이수기록도 같이 삭제해야한다.")
    public void deleteEmployeeEducatedResultTest(){
        //given
        Long empno = 500L; //더미 유저
        //when
        Integer deleteEmployeeEducatedResult = deleteService.deleteEmployeeEducated(empno);
        //then
        Assertions.assertThat(deleteEmployeeEducatedResult).isNotEqualTo(null);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원 삭제시 커리큘럼 이수기록이 없을경우 0을 반환한다.")
    public void deleteEmployeeNotEducatedResultTest(){
        //given
        Long empno = 100L; //없는 유저
        //when
        Integer deleteEmployeeEducatedResult = deleteService.deleteEmployeeEducated(empno);
        //then
        Assertions.assertThat(deleteEmployeeEducatedResult).isEqualTo(0);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원 삭제를 할 수 있어야 한다.")
    public void deleteEmployeeResultTest(){
        //given
        Long empno = 520L; //실제 유저
        //when
        Integer deleteEmployee = deleteService.deleteEmployee(empno);
        //then
        Assertions.assertThat(deleteEmployee).isEqualTo(1);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원 삭제를 할 수 있어야 한다.")
    public void notDeleteEmployeeResultTest(){
        //given
        Long empno = 1000000L; //없는 유저
        //when
        Integer deleteEmployee = deleteService.deleteEmployee(empno);
        //then
        Assertions.assertThat(deleteEmployee).isEqualTo(0);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원 삭제시 departemnt 테이블의 manager 정보가 등록되어있을경우 업데이트")
    public void deleteManagerDepartmentTest(){
        //given
        Long empno = 501L; //더미 유저
        //when
        Integer deleteManagerDepartment = deleteService.deleteManagerDepartment(empno);
        //then
        Assertions.assertThat(deleteManagerDepartment).isNotEqualTo(0);
    }

    @Test
    @Transactional //자동 rollback
    @DisplayName("사원 삭제시 departemnt 테이블의 manager 정보가 없을경우 업데이트 x")
    public void notDeleteManagerDepartmentTest(){
        //given
        Long empno = 100000L; //없는 유저
        //when
        Integer deleteManagerDepartment = deleteService.deleteManagerDepartment(empno);
        //then
        Assertions.assertThat(deleteManagerDepartment).isEqualTo(0);
    }

}
