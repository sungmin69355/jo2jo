package com.metanet.jo2jo.service.curriculum;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumDetailService {
    private final CurriculumRepository curriculumRepository;

    public Optional<CurriculumDto> findOneCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.findOneCurriculum(curriculumDto);
    }
}
