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
        if(session.getAttribute("user") != null){
            if (session.getAttribute("user").equals("admin") || session.getAttribute("user").equals("employee") ) {
                return "redirect:/employees";
            }
        }
        return "login/main";
    }
}
