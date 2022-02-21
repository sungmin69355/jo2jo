package com.metanet.jo2jo.service.educated;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.repository.Educated.EducatedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducatedInsertService {
    private final EducatedRepository educatedRepository;

    public Long signUpForClass(EducatedDto educatedDto){
        return educatedRepository.insertEducated(educatedDto);
    }

    public int findCurriculumState(EducatedDto educatedDto){
        return educatedRepository.selectEducatedState(educatedDto);
    }

}
