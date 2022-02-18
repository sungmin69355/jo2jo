package com.metanet.jo2jo.curriculum.curriculumSelect;

import com.metanet.jo2jo.domain.commons.Criteria;
import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.service.curriculum.CurriculumSelectService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CurriculumSelectServiceTest {
    @Autowired
    private CurriculumSelectService curriculumSelectService;

    @Test
    @DisplayName("커리큘럼 메인페이지(10행) 조회가 가능해야 한다")
    public void selectCurriculum1to10Test(){
        //given

        //when
        List<CurriculumDto> curriculumList = curriculumSelectService.curriculumList(new CurriculumDto());
        int defaultRecordsPerPage = new Criteria().getRecordsPerPage();    //페이지당 기본 레코드 수

        //then
        Assertions.assertThat(curriculumList.size()).isEqualTo(defaultRecordsPerPage);
    }

    @Test
    @DisplayName("커리큘럼 메인페이지에서 커리큘럼 이름으로 검색이 가능해야 한다")
    public void searchByCurrnameInCurriculum(){
        //given
        String searchKeyword = "바리스타";
        CurriculumDto curriculumDto = new CurriculumDto();
        curriculumDto.setSearchType("currname");
        curriculumDto.setSearchKeyword(searchKeyword);

        //when
        List<CurriculumDto> curriculumList = curriculumSelectService.curriculumList(new CurriculumDto());

        //then
        Assertions.assertThat(curriculumList.get(0).getCurrname().contains(searchKeyword));
    }

    @Test
    @DisplayName("커리큘럼 메인페이지에서 내용으로 검색이 가능해야 한다")
    public void searchByContentInCurriculum(){
        //given
        String searchKeyword = "캘리그라피";
        CurriculumDto curriculumDto = new CurriculumDto();
        curriculumDto.setSearchType("content");
        curriculumDto.setSearchKeyword(searchKeyword);

        //when
        List<CurriculumDto> curriculumList = curriculumSelectService.curriculumList(new CurriculumDto());

        //then
        Assertions.assertThat(curriculumList.get(0).getContent().contains(searchKeyword));
    }

    @Test
    @DisplayName("커리큘럼 메인페이지에서 강사이름으로 검색이 가능해야 한다")
    public void searchByInstructorInCurriculum(){
        //given
        String searchKeyword = "민국";
        CurriculumDto curriculumDto = new CurriculumDto();
        curriculumDto.setSearchType("instructor");
        curriculumDto.setSearchKeyword(searchKeyword);

        //when
        List<CurriculumDto> curriculumList = curriculumSelectService.curriculumList(new CurriculumDto());

        //then
        Assertions.assertThat(curriculumList.get(0).getInstructor().contains(searchKeyword));
    }
}
