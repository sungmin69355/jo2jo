package com.metanet.jo2jo.service.curriculum;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumRegisterService {
    private final CurriculumRepository curriculumRepository;
    private final DepartmentRepository departmentRepository;

    public CurriculumDto saveCurriculum(CurriculumDto curriculumDto){
        curriculumRepository.registerCurriculum(curriculumDto);
        curriculumDto.setCurrno(curriculumRepository.findCurrSequenceNo()-1L);
        return curriculumDto;   //커리큘럼 이름 필요
    }

    public Optional<CurriculumDto> findOneCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.findOneCurriculum(curriculumDto);
    }

    public Long registerCurriculumCostotalcnt(CurriculumDto curriculumDto){
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

    public List<DepartmentDto> findLowestDepartment(){
        return departmentRepository.findLowestDepartment();
    }

    public Long findCurrSequenceNo(){
        return curriculumRepository.findCurrSequenceNo();
    }
}
