package com.metanet.jo2jo.educated.educatedUpdate;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.service.educated.EducatedSelectService;
import com.metanet.jo2jo.service.educated.EducatedUpdateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EducatedUpdateServiceTest {
    @Autowired
    private EducatedUpdateService educatedUpdateService;
    @Autowired
    private EducatedSelectService educatedSelectService;

    @Test
    @Transactional
    @DisplayName("각 코스 이수 시 교육 이수 테이블에 업데이트되어야 한다")
    public void updateEducatedTest(){
        //given
        Long currno = 1001L; //커리큘럼 1001L
        Long edustate = 1L;  //코스 1개 들었다.
        EducatedDto educatedDto = new EducatedDto();
        educatedDto.setCurrno(currno);
        educatedDto.setEdustate(edustate);

        //when
        Long result = educatedUpdateService.updateProgressOfClass(educatedDto);

        //then
        Assertions.assertThat(result==1);
    }
}
