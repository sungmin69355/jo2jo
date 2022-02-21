package com.metanet.jo2jo.educated.educatedDelete;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.service.educated.EducatedDeleteService;
import com.metanet.jo2jo.service.educated.EducatedInsertService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EducatedDeleteServiceTest {
    @Autowired
    private EducatedDeleteService educatedDeleteService;
    @Autowired
    private EducatedInsertService educatedInsertService;

    @Test
    @DisplayName("교육 이수 내역이 삭제 가능해야 한다")
    public void deleteEducatedTest(){
        //given
        EducatedDto educatedDto = new EducatedDto();
        educatedDto.setEmpno(1L);       //사장
        educatedDto.setCurrno(1001L);   //마케팅의이해
        educatedInsertService.signUpForClass(educatedDto);
        int beforeState = educatedInsertService.findCurriculumState(educatedDto);

        //when
        educatedDeleteService.deleteEducated(educatedDto);
        int afterState = educatedInsertService.findCurriculumState(educatedDto);

        //then
        Assertions.assertThat(beforeState!=afterState);
    }

}
