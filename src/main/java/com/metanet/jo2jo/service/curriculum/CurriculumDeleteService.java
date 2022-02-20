package com.metanet.jo2jo.service.curriculum;

import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurriculumDeleteService {
    private final CurriculumRepository curriculumRepository;

    public Long deleteCurriculum(Long currno){
        return curriculumRepository.deleteCurriculum(currno);
    }
}
