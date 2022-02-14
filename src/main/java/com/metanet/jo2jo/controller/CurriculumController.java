package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.service.CurriculumRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CurriculumController {
    private final CurriculumRegisterService curriculumRegisterService;

    //커리큘럼 등록
    @GetMapping("/curriculum/new")
    String curriculumRegisterForm(){
        CurriculumDto curriculumDto = new CurriculumDto(
                1000L
                , "테스트커리큘럼"
                , 70000L
                , "2022-02-10"
                , "2022-03-12"
                , "ST부문 공공부문 금융사업본 교육사업본부 서비스부문 뱅킹부문 ES사업본부 ITO사업본부"
                , "테스트내용"
                , "테스트강사"
                , "테스트코스1"
                , "테스트코스2"
                , "테스트코스3"
                , "테스트코스4"
                , "테스트코스5"
                , null
        );

        //when
        Long saveCurriculum = curriculumRegisterService.newCurriculum(curriculumDto);

        return "curriculum/curriculum-register";
    }

    @PostMapping("/curriculum/new")
    String curriculumRegister(){
        return "redirect: curriculum/curriculum-main";
    }
}
