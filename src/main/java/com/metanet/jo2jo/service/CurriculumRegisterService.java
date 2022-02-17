package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import com.metanet.jo2jo.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurriculumRegisterService {
    private final CurriculumRepository curriculumRepository;
    private final DepartmentRepository departmentRepository;

    public CurriculumDto saveCurriculum(CurriculumDto curriculumDto){
        curriculumRepository.registerCurriculum(curriculumDto);
        return curriculumDto;   //커리큘럼 이름 필요
    }

    public Optional<CurriculumDto> findOneCurriculum(CurriculumDto curriculumDto){
        return curriculumRepository.findOneCurriculum(curriculumDto);
    }

    public Long registerCurriculumCostotalcnt(CurriculumDto curriculumDto){
        Long count = 0L;
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos1()!=""){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos2()!=""){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos3()!=""){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos4()!=""){
            count++;
        }
        if(curriculumRepository.findOneCurriculum(curriculumDto).get().getEducos5()!=""){
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
