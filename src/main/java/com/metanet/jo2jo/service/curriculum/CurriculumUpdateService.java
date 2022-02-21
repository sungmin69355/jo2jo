package com.metanet.jo2jo.service.curriculum;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumUpdateService {
    private final CurriculumRepository curriculumRepository;

    public Optional<CurriculumDto> findOneCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.findOneCurriculum(curriculumDto);
    }

    public Long updateCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.updateCurriculum(curriculumDto);
    }

    public Long updateCurriculumCostotalcnt(CurriculumDto curriculumDto){
        Long count = 0L;
        if(!StringUtils.isEmpty(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos1())){
            count++;
        }
        if(!StringUtils.isEmpty(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos2())){
            count++;
        }
        if(!StringUtils.isEmpty(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos3())){
            count++;
        }
        if(!StringUtils.isEmpty(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos4())){
            count++;
        }
        if(!StringUtils.isEmpty(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos5())){
            count++;
        }
        curriculumDto.setCostotalcnt(count);
        curriculumRepository.registerCurriculumCostotalcnt(curriculumDto);
        return count;
    }

    public Long findCurrSequenceNo(){
        return curriculumRepository.findCurrSequenceNo();
    }

    public CurriculumDto saveCurriculum(CurriculumDto curriculumDto){
        curriculumRepository.registerCurriculum(curriculumDto);
        curriculumDto.setCurrno(curriculumRepository.findCurrSequenceNo()-1L);
        return curriculumDto;
    }

}
