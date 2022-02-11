package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurriculumRegisterService {
    private final CurriculumRepository curriculumRepository;

    public int registerCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.registerCurriculum(curriculumDto);
    }

    public int registerCurriculumCostotalCnt(CurriculumDto curriculumDto){
        return curriculumRepository.registerCurriculumCostotalCnt(curriculumDto);
    }
}
