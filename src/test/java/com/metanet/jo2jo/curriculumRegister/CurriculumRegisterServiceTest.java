package com.metanet.jo2jo.curriculumRegister;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.service.CurriculumRegisterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CurriculumRegisterServiceTest {
    @Autowired
    private CurriculumRegisterService curriculumRegisterService;

    @Test
    @DisplayName("커리큘럼 등록이 가능해야 한다")
    public void registerCurriculumTest(){
        //given
        CurriculumDto curriculumDto = new CurriculumDto(
                1000L
                , "테스트커리큘럼"
                , 70000L
                , "2022-02-10"
                , "2022-03-12"
                , "ST부문 공공부문 금융사업본 교육사업본부 서비스부문 뱅킹부문 ES사업본부 ITO사업본부"
                , "테스트내용"
                , "테스트강사"
                , "테스트코스1"
                , "테스트코스2"
                , "테스트코스3"
                , "테스트코스4"
                , "테스트코스5"
                , null
        );

        //when
        Long saveCurrno = curriculumRegisterService.registerCurriculum(curriculumDto);

        //then
        CurriculumDto findCurriculum = curriculumRegisterService.findOneCurriculum(saveCurrno).get();
        Assertions.assertThat(curriculumDto.getCurrname()).isEqualTo(findCurriculum.getCurrname());
    }
}
