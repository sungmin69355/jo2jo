package com.metanet.jo2jo.repository.curriculum;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface CurriculumRepository {
    Long registerCurriculum(CurriculumDto curriculumDto);
    Optional<CurriculumDto> findOneCurriculum(CurriculumDto curriculumDto);
    int registerCurriculumCostotalcnt(CurriculumDto curriculumDto); //코스 총 개수 costotalcnt 등록
    Long findCurrSequenceNo();

    Integer selectCurriculumTotalCount(CurriculumDto curriculumDto);    //커리큘럼 토탈카운트
    List<CurriculumDto> selectCurriculum(CurriculumDto curriculumDto);  //메인페이지 조회
}
