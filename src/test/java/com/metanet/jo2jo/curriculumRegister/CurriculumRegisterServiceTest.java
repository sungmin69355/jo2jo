package com.metanet.jo2jo.curriculumRegister;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.service.CurriculumRegisterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class CurriculumRegisterServiceTest {
    @Autowired
    private CurriculumRegisterService curriculumRegisterService;

    @Test
    @Transactional
    @DisplayName("커리큘럼 등록이 가능해야 한다")
    public void registerCurriculumTest(){
        //given
        Long currSequenceNo = curriculumRegisterService.findCurrSequenceNo();
        CurriculumDto curriculumDto = new CurriculumDto(
                currSequenceNo   //SEQ_CURRICULUM_NO.NEXTVAL
                , "테스트커리큘럼"
                , 70000L
                , "02/16/2022"
                , "03/16/2022"
                , "ST부문 공공부문 금융사업본 교육사업본부 서비스부문 뱅킹부문 ES사업본부 ITO사업본부"
                , "테스트내용"
                , "테스트강사"
                , "테스트코스1"
                , "테스트코스2"
                , "테스트코스3"
                , "테스트코스4"
                , "테스트코스5"
                , null  //costotalcnt
        );

        //when
        CurriculumDto saveCurriculum = curriculumRegisterService.saveCurriculum(curriculumDto);

        //then
        CurriculumDto findCurriculum = curriculumRegisterService.findOneCurriculum(saveCurriculum).get();
        Assertions.assertThat(curriculumDto.getCurrname()).isEqualTo(findCurriculum.getCurrname());
    }

    @Test
    @Transactional
    @DisplayName("커리큘럼 등록이 되면 코스 총 개수가 업데이트되어야 한다")
    public void registerCostotalCntTest(){
        //given
        Long currSequenceNo = curriculumRegisterService.findCurrSequenceNo();
        CurriculumDto curriculumDto = new CurriculumDto(
                currSequenceNo    //SEQ_CURRICULUM_NO.NEXTVAL
                , "테스트커리큘럼"
                , 70000L
                , "02/16/2022"
                , "03/16/2022"
                , "ST부문 공공부문 금융사업본 교육사업본부 서비스부문 뱅킹부문 ES사업본부 ITO사업본부"
                , "테스트내용"
                , "테스트강사"
                , "테스트코스1"
                , "테스트코스2"
                , "테스트코스3"
                , "테스트코스4"
                , "테스트코스5"
                , null  //costotalcnt
        );

        //when
        CurriculumDto newCurriculum = curriculumRegisterService.saveCurriculum(curriculumDto);
        Long newCostotalcnt = curriculumRegisterService.registerCurriculumCostotalcnt(curriculumDto);

        //then
        CurriculumDto findCurriculum = curriculumRegisterService.findOneCurriculum(newCurriculum).get();
        Assertions.assertThat(newCostotalcnt).isEqualTo(findCurriculum.getCostotalcnt());
    }

    @Test
    @DisplayName("커리큘럼 등록할 때 최하위 부서를 조회할 수 있어야 한다.")
    public void findLowestDepartmentTest(){
        //given

        //when
        List<DepartmentDto> resultList = curriculumRegisterService.findLowestDepartment();

        //then
        System.out.println("최하위부서 총 행 수:" + resultList.size());
        for(DepartmentDto departmentDto : resultList) {
            System.out.println(departmentDto.toString());
        }
        Assertions.assertThat(resultList);
    }
}
