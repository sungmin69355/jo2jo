package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurriculumController {

    //커리큘럼 등록
    @GetMapping("/curriculum")
    String curriculumRegisterForm(){
        return "curriculum/curriculum-register";
    }
}
