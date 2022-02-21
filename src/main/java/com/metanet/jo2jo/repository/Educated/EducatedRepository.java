package com.metanet.jo2jo.repository.Educated;

import java.util.List;
import java.util.Optional;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.jo2jo.domain.educated.EducatedSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;

@Repository
@Mapper
public interface EducatedRepository {

	List<EducatedSelectDto> selectEducated(EmployeeDetailDto employeeDetailDto);

	int selectEducatedState(EducatedDto educatedDto);
	Long insertEducated(EducatedDto educatedDto); //수강신청
	Long updateEducated(EducatedDto educatedDto); //수강업데이트

	Long deleteEducated(EducatedDto educatedDto); //수강 삭제(사원 삭제, 커리큘럼 삭제 하기 전)

  List<EducatedSelectDto> selectEducated(EmployeeDetailDto employeeDetailDto);
  Integer deleteEmployeeEducated(Long enpno);

}
