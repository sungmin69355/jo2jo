package com.metanet.jo2jo.curriculum.curriculumUpdate;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.service.curriculum.CurriculumUpdateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CurriculumUpdateServiceTest {
    @Autowired
    private CurriculumUpdateService curriculumUpdateService;

    @Test
    @Transactional
    @DisplayName("커리큘럼 수정이 가능해야 한다")
    public void updateCurriculumTest(){
        //given
        Long currSequenceNo = curriculumUpdateService.findCurrSequenceNo();
        CurriculumDto beforeCurriculum = new CurriculumDto(
                null
                , currSequenceNo   //SEQ_CURRICULUM_NO.NEXTVAL
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
        CurriculumDto oldCurriculum = curriculumUpdateService.saveCurriculum(beforeCurriculum);

        //when
        CurriculumDto afterCurriculum = new CurriculumDto(
                null
                , currSequenceNo
                , "수정할커리큘럼"
                , 70000L
                , "02/16/2022"
                , "03/16/2022"
                , "교육사업본부 서비스부문 ES사업본부 ITO사업본부"
                , "수정할내용"
                , "수정강사"
                , "수정코스1"
                , "수정코스2"
                , ""
                , ""
                , "수정코스3"
                , null  //costotalcnt
        );
        curriculumUpdateService.updateCurriculum(afterCurriculum);

        //then
        CurriculumDto newCurriculum = curriculumUpdateService.findOneCurriculum(oldCurriculum).get(); //예전꺼 currno로 조회
        Assertions.assertThat(newCurriculum.getCurrname()).isEqualTo("수정할커리큘럼");

    }

    @Test
    @Transactional
    @DisplayName("코스 총 개수 수정이 되어야 한다")
    public void updateCurriculumCostotalCntTest(){
        //given
        Long currSequenceNo = curriculumUpdateService.findCurrSequenceNo();
        CurriculumDto beforeCurriculum = new CurriculumDto(
                null
                , currSequenceNo   //SEQ_CURRICULUM_NO.NEXTVAL
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
        CurriculumDto oldCurriculum = curriculumUpdateService.saveCurriculum(beforeCurriculum);
        Long oldCostotalcnt = curriculumUpdateService.updateCurriculumCostotalcnt(beforeCurriculum);

        //when
        CurriculumDto afterCurriculum = new CurriculumDto(
                null
                , currSequenceNo
                , "수정할커리큘럼"
                , 70000L
                , "02/16/2022"
                , "03/16/2022"
                , "교육사업본부 서비스부문 ES사업본부 ITO사업본부"
                , "수정할내용"
                , "수정강사"
                , "수정코스1"
                , "수정코스2"
                , ""
                , ""
                , "수정코스3"
                , null  //costotalcnt
        );
        curriculumUpdateService.updateCurriculum(afterCurriculum);
        Long newCostotalcnt = curriculumUpdateService.updateCurriculumCostotalcnt(afterCurriculum);

        //then
        CurriculumDto findCurriculum = curriculumUpdateService.findOneCurriculum(afterCurriculum).get();
        Assertions.assertThat(newCostotalcnt).isEqualTo(findCurriculum.getCostotalcnt());

    }

    @Test
    @Transactional
    @DisplayName("커리큘럼 삭제가 가능해야 한다")
    public void deleteCurriculumTest(){

    }
}
