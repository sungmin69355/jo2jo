package com.metanet.jo2jo.curriculum.curriculumDelete;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.service.curriculum.CurriculumDeleteService;
import com.metanet.jo2jo.service.curriculum.CurriculumSelectService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CurriculumDeleteServiceTest {
    @Autowired
    CurriculumDeleteService curriculumDeleteService;
    @Autowired
    CurriculumSelectService curriculumSelectService;

    @Test
    @Transactional
    @DisplayName("커리큘럼 삭제가 가능해야 한다")
    public void deleteCurriculumTest(){
        //given
        Integer beforetotal = curriculumSelectService.findCurriculumTotalCount(new CurriculumDto());
        Long currno = 1001L;    //1001L 커리큘럼

        //when
        curriculumDeleteService.deleteCurriculum(currno);

        //then
        Integer afterTotal = curriculumSelectService.findCurriculumTotalCount(new CurriculumDto());
        Assertions.assertThat(beforetotal.intValue()==afterTotal.intValue()+1);
    }
}
