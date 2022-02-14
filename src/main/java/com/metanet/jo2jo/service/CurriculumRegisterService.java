package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumRegisterService {
    private final CurriculumRepository curriculumRepository;

    public Long newCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.registerCurriculum(curriculumDto);
    }

    public Optional<CurriculumDto> findOneCurriculum(Long currno){
        return curriculumRepository.findOneCurriculum(currno);
    }

    public int registerCurriculumCostotalcnt(CurriculumDto curriculumDto){
        return curriculumRepository.registerCurriculumCostotalcnt(curriculumDto);
    }
}
