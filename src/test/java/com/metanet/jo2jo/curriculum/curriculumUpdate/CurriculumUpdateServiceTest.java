package com.metanet.jo2jo.curriculum.curriculumUpdate;

import com.metanet.jo2jo.service.curriculum.CurriculumUpdateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CurriculumUpdateServiceTest {
    @Autowired
    private CurriculumUpdateService curriculumUpdateService;

    @Test
    @Transactional
    @DisplayName("커리큘럼 수정이 가능해야 한다")
    public void updateCurriculumTest(){

    }
}
