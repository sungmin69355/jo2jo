package com.metanet.jo2jo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String home(){
        return "index";
    }

    @GetMapping("/1")
    String home1(){
        return "accordion";
    }
}
