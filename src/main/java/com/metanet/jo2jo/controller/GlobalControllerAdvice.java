package com.metanet.jo2jo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String exception(Exception e,Model model) {
        System.out.println("오류");
        System.out.println(e.getMessage());
        model.addAttribute("exception",e);
        return "404";
    }
}
