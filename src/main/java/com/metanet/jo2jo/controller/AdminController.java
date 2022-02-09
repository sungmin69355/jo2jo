package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.EmployeeRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final EmployeeRegisterService employeeRegisterService;

    @GetMapping("/employee")
    String employeeRegisterForm(HttpSession session, Model model){
        //부서 정보
        List<DepartmentDto> findByAllDepartment = employeeRegisterService.findAllByDepartment();
        //직급 정보
        List<PositionDto> findAllByPosition = employeeRegisterService.findAllByPosition();

        model.addAttribute("findByAllDepartment",findByAllDepartment);
        model.addAttribute("findAllByPosition",findAllByPosition);
        return "employee/employee-register";
    }

    @PostMapping("/employee")
    String employeeRegister(HttpSession session, HttpServletRequest request, @Valid EmployeeRegisterForm employeeRegisterForm, BindingResult bindingResult){

        if(session.getAttribute("user").equals("admin")){
            //Valid 검증
            if (bindingResult.hasErrors()) {
                return "employee/employee-register";
            }
            //insert로직

            //결과
        }else{
            return "/employee/employee-main";
        }

        return "/employee/employee-main";
    }
  

 }
