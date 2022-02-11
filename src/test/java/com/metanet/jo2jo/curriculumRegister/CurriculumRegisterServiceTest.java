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
    @Transactional
    @DisplayName("커리큘럼 등록이 가능해야 한다")
    public void registerCurriculumTest(){
        //given
        CurriculumDto curriculumDto = new CurriculumDto(
                1011L
                , "테스트"
                , 70000L
                , "2022-02-10"
                , "2022-03-12"
                , "ST부문 공공부문 금융사업본 교육사업본부 서비스부문 뱅킹부문 ES사업본부 ITO사업본부"
                , "테스트내용"
                , "강사아름"
                , "테스트코스1"
                , "테스트코스2"
                , "테스트코스3"
                , null
                , null
                , null
        );

        //when
        int registerCurriculumRegister = curriculumRegisterService.registerCurriculum(curriculumDto);

        //then
        Assertions.assertThat()
    }
}
