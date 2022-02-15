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
        return "curriculum/curriculum-register";
    }

    @GetMapping("/curriculum/2")
    String curriculumRegisterForm2(){
        return "curriculum/form-elements-advance";
    }

    @PostMapping("/curriculum/new")
    String curriculumRegister(){
        return "redirect: curriculum/curriculum-main";
    }
}
