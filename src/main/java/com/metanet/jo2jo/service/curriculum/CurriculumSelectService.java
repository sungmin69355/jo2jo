package com.metanet.jo2jo.service.curriculum;

import com.metanet.jo2jo.domain.commons.PaginationInfo;
import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.repository.curriculum.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurriculumSelectService {
    private final CurriculumRepository curriculumRepository;

    /* 관리자 */
    public Integer findCurriculumTotalCount(CurriculumDto curriculumDto){
        return curriculumRepository.selectCurriculumTotalCount(curriculumDto);
    }
    public List<CurriculumDto> curriculumList(CurriculumDto curriculumDto){
        //list가 비어있을때를 고려하기 위해 빈 리스트 생성
        List<CurriculumDto> emptyCurriculumList = Collections.emptyList();
        int curriculumTotalCount = curriculumRepository.selectCurriculumTotalCount(curriculumDto);
        PaginationInfo paginationInfo = new PaginationInfo(curriculumDto);
        paginationInfo.setTotalRecordCount(curriculumTotalCount);

        curriculumDto.setPaginationInfo(paginationInfo);

        if(curriculumTotalCount > 0){
            return curriculumRepository.selectCurriculum(curriculumDto);
        }else{
            return emptyCurriculumList;
        }
    }


    /* 사원 */
    public Integer findCurriculumTotalCountFromEmp(CurriculumDto curriculumDto){
        return curriculumRepository.selectCurriculumTotalCountFromEmp(curriculumDto);
    }
    public List<CurriculumDto> curriculumListFromEmp(CurriculumDto curriculumDto){
        //list가 비어있을때를 고려하기 위해 빈 리스트 생성
        List<CurriculumDto> emptyCurriculumList = Collections.emptyList();
        int curriculumTotalCount = curriculumRepository.selectCurriculumTotalCount(curriculumDto);
        PaginationInfo paginationInfo = new PaginationInfo(curriculumDto);
        paginationInfo.setTotalRecordCount(curriculumTotalCount);

        curriculumDto.setPaginationInfo(paginationInfo);

        if(curriculumTotalCount > 0){
            return curriculumRepository.selectCurriculumFromEmp(curriculumDto);
        }else{
            return emptyCurriculumList;
        }
    }


}
