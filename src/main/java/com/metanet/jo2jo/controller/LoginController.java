package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginDto loginDto, HttpSession session) {

        if (session != null) {
            return "index";
        }
        return "/login/main";
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute LoginDto loginDto, @RequestParam String employee, HttpServletRequest request){

        HttpSession session;

        if(employee.equals("admin")){
            //어드민 로그인
            System.out.print(loginDto.toString());
            System.out.println(employee);
            AdminDto adminDto  = loginService.adminFindByLoginId(loginDto);
            if (adminDto == null) {
                return "login/main";
            }
            session = request.getSession();
            session.setAttribute("user" , employee);
        }else if(employee.equals("employee")) {
            //사원 로그인
            EmployeeDto employeeDto = loginService.employeeFindByLoginId(loginDto);
            if (employeeDto == null) {
                return "login/main";
            }
            session = request.getSession();
            session.setAttribute("user" , employee);
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

        return "/login/main";
    }
}
