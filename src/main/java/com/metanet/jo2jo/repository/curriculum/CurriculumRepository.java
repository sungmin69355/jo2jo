package com.metanet.jo2jo.repository.curriculum;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CurriculumRepository {
    int registerCurriculum(CurriculumDto curriculumDto);
    int registerCurriculumCostotalCnt(CurriculumDto curriculumDto);
}
