package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.Login.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    String home(Model model, HttpSession session){
        model.addAttribute("loginDto", new LoginDto());
        System.out.println(session);
        if (session != null) {
            return "login/main";
        }
        return "redirect:/employees";
    }

    @GetMapping("/index")
    String index(Model model, HttpSession session){
        model.addAttribute("loginDto", new LoginDto());
        System.out.println(session.getAttribute("info"));
        if (session != null) {
            return "login/main";
        }
        return "index";
    }
}
