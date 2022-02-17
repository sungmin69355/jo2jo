package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.department.DepartmentDetailDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.domain.department.DepartmentOzDto;
import com.metanet.jo2jo.service.DepartmentDetailService;
import com.metanet.jo2jo.service.DepartmentRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRegisterService departmentRegisterService;
    private final DepartmentDetailService departmentDetailService;
    
    @GetMapping("/departments")
    String departmentMain(Model model) {
    	return "department/department-main";
    }
    @GetMapping("/department/new")
    String departmentRegisterForm(HttpSession session, Model model){
        if (session.getAttribute("user").equals("admin")) {
            List<DepartmentDto> findByAllDepartment = departmentRegisterService.findAllByDepartment();
            model.addAttribute("departmentForm", new DepartmentForm());
            model.addAttribute("findByAllDepartment", findByAllDepartment);
            return "department/department-register";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/department/new")
    String departmentRegister(HttpSession session, Model model, @Valid DepartmentForm departmentForm, BindingResult bindingResult){
        if (session.getAttribute("user").equals("admin")) {
            //Valid 검증
            if (bindingResult.hasErrors()) {
//                Map map = bindingResult.getModel(); //테스트용
//                Set keys = map.keySet();
//                Iterator it = keys.iterator();
//                while(it.hasNext()) {
//                    Object key = it.next();
//                    Object val = map.get(key);
//                    System.out.println("에러내용 :: "+val);
//                }

                List<DepartmentDto> findByAllDepartment = departmentRegisterService.findAllByDepartment();
                model.addAttribute("departmentForm", new DepartmentForm());
                model.addAttribute("findByAllDepartment", findByAllDepartment);
                return "department/department-register";
            }
            Integer insertDepartment = departmentRegisterService.insertDepartment(departmentForm);
            return "redirect:/";
        }
        return "redirect:/";
    }
    @GetMapping("/department/{deptNo}")
    String departmentDetailForm(HttpSession session, Model model, @PathVariable Long deptNo){
        if(session.getAttribute("user") != null){
            DepartmentDetailDto departmentDetailDto  = departmentDetailService.selectDepartment(deptNo);
            model.addAttribute("departmentDetailDto",departmentDetailDto);
            return "department/department-detail";
        }
        return "redirect:/employees";
    }
    @GetMapping("/organization")
    String departments(HttpSession session, Model model){
        if(session.getAttribute("user") != null){
            List<DepartmentDto> departmentDto = departmentRegisterService.findAllByDepartment();
            model.addAttribute("departmentDto",departmentDto);
            return"department/organization";
        }
        return "redirect:/employees";
    }
}
