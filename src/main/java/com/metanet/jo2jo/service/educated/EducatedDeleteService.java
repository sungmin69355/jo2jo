package com.metanet.jo2jo.service.educated;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.repository.Educated.EducatedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducatedDeleteService {
    private final EducatedRepository educatedRepository;

    public Long deleteEducated(EducatedDto educatedDto){
        return educatedRepository.deleteEducated(educatedDto);
    }
}
