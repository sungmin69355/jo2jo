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

    public CurriculumDto newCurriculum(CurriculumDto curriculumDto){   //커리큘럼 이름 반환
        curriculumRepository.registerCurriculum(curriculumDto);
        return curriculumDto;
    }

    public Optional<CurriculumDto> findOneCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.findOneCurriculum(curriculumDto);
    }

    public Long registerCurriculumCostotalcnt(CurriculumDto curriculumDto){
        Long count = 0L;
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos1()!=null){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos2()!=null){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos3()!=null){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos4()!=null){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos5()!=null){
            count++;
        }
        curriculumDto.setCostotalcnt(count);
        curriculumRepository.registerCurriculumCostotalcnt(curriculumDto);
        return count;
    }
}
