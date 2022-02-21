package com.metanet.jo2jo.educated.educatedUpdate;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.service.educated.EducatedInsertService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EducatedInsertServiceTest {
    @Autowired
    private EducatedInsertService educatedInsertService;

    @Test
    @Transactional
    @DisplayName("수강 신청 시 교육 이수 테이블에 등록되어야 한다")
    public void insertEducatedTest(){
        //given
        EducatedDto educatedDto = new EducatedDto();
        educatedDto.setEmpno(2004L);
        educatedDto.setCurrno(2058L);

        //when
        educatedInsertService.signUpForClass(educatedDto);
        int listeningCurriculumCnt = educatedInsertService.findCurriculumState(educatedDto);

        //then
        Assertions.assertThat(listeningCurriculumCnt==1);

    }


}
