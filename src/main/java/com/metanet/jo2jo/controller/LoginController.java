package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session) {
        model.addAttribute("loginDto", new LoginDto());
        if (session.getAttribute("user") == null) {
            return "login/main";
        }
        return "index";
    }

    @PostMapping("/login")
    public String loginCheck(@ModelAttribute("loginDto") @Valid LoginDto loginDto, BindingResult bindingResult, @RequestParam(value="employee", required=false) String employee, HttpServletRequest request){

        HttpSession session;
        if(employee == null){
            return "login/main";
        }

        if (bindingResult.hasErrors()) {
            return "login/main";
        }

        if(employee.equals("admin")){
            //어드민 로그인
            AdminDto adminDto  = loginService.adminFindByLoginId(loginDto);
            if (adminDto == null) {
                return "login/main";
            }
            session = request.getSession();
            session.setAttribute("user" , employee);
            session.setAttribute("info", adminDto);

        }else if(employee.equals("employee")) {
            //사원 로그인
            EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);
            if (employeeDto == null) {
                return "login/main";
            }
            session = request.getSession();
            session.setAttribute("user" , employee);
            session.setAttribute("info", employeeDto);
        }
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {

        model.addAttribute("loginDto", new LoginDto());
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

        return "login/main";
    }
}
