package com.metanet.jo2jo.curriculumDetail;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.service.CurriculumDetailService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CurriculumDetailServiceTest {
    @Autowired
    private CurriculumDetailService curriculumDetailService;

    @Test
    @DisplayName("커리큘럼 pk에 따른 상세 조회가 가능해야 한다")
    public void detailCurriculumTest(){
        //given
        CurriculumDto curriculumDto = new CurriculumDto();
        curriculumDto.setCurrno(1001L);
        curriculumDto.setCurrname("마케팅의 이해");

        //when
        CurriculumDto resultCurriculum = curriculumDetailService.findOneCurriculum(curriculumDto).get();
        System.out.println(resultCurriculum);

        //then
        Assertions.assertThat(resultCurriculum.getCurrname()).isEqualTo(curriculumDto.getCurrname());
    }
}
