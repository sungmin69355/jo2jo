package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.EmployeeRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRegisterService employeeRegisterService;

    //사원조회 부서추가
    @GetMapping("/employees")
    String employeeMain(@ModelAttribute("params") EmployeeSelectDto params, Model model) {
        model.addAttribute("employeelist", employeeService.employeelist(params));
        return "employee/employee-main";

    }

    //사원 등록 페이지
    @GetMapping("/employee")
    String employeeRegisterForm(HttpSession session, Model model) {
        if (session.getAttribute("user").equals("admin")) {
            //부서 정보
            List<DepartmentDto> findByAllDepartment = employeeRegisterService.findAllByDepartment();
            //직급 정보
            List<PositionDto> findAllByPosition = employeeRegisterService.findAllByPosition();

            model.addAttribute("findByAllDepartment", findByAllDepartment);
            model.addAttribute("findAllByPosition", findAllByPosition);
            model.addAttribute("employeeRegisterForm", new EmployeeRegisterForm());
            return "employee/employee-register";
        } else {
            return "index";
        }
    }

    //사원 등록
    @PostMapping("/employee")
    String employeeRegister(HttpSession session, Model model, @Valid EmployeeRegisterForm employeeRegisterForm, BindingResult bindingResult) {

        if (session.getAttribute("user").equals("admin")) {
            System.out.println(employeeRegisterForm.toString());
            //Valid 검증
            if (bindingResult.hasErrors()) {
                //부서 정보
                List<DepartmentDto> findByAllDepartment = employeeRegisterService.findAllByDepartment();
                //직급 정보
                List<PositionDto> findAllByPosition = employeeRegisterService.findAllByPosition();
                model.addAttribute("findByAllDepartment", findByAllDepartment);
                model.addAttribute("findAllByPosition", findAllByPosition);
                return "employee/employee-register";
            }
            //insert 로직
        }
        return "index";
    }


}
