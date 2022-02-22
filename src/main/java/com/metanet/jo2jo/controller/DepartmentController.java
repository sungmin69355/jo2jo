package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.department.DepartmentDetailDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.department.DepartmentForm;
import com.metanet.jo2jo.domain.department.DepartmentOzDto;
import com.metanet.jo2jo.domain.department.DepartmentSelectDto;

import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.department.DepartmentDeleteService;
import com.metanet.jo2jo.service.department.DepartmentDetailService;
import com.metanet.jo2jo.service.department.DepartmentRegisterService;
import com.metanet.jo2jo.service.department.DepartmentSelectService;
import com.metanet.jo2jo.service.department.DepartmentUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    private final DepartmentSelectService departmentSelectService;
    private final DepartmentDeleteService departmentDeleteService;  
    //부서조회 메인페이지


    private final DepartmentUpdateService departmentUpdateService;
    

    @GetMapping("/departments")
    String departmentMain(HttpSession session, Model model, @ModelAttribute("params") DepartmentSelectDto params) {
    	if(session.getAttribute("user").equals("admin") || session.getAttribute("user").equals("employee")) {
    				
	     	model.addAttribute("departmentlist",departmentSelectService.selectDepartment(params));
	    	return "department/department-main";
    	} else {
    		session.invalidate();
  		    return "redirect:index";
    	}
    }
  
    @GetMapping("/department/new")
    String departmentRegisterForm(HttpSession session, Model model){
        if (session.getAttribute("user").equals("admin")) {
            List<DepartmentDto> findByAllDepartment = departmentRegisterService.findAllByDepartment();
            model.addAttribute("departmentForm", new DepartmentForm());
            model.addAttribute("findByAllDepartment", findByAllDepartment);
            return "department/department-register";
        }else{
            return "redirect:/departments";
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
            return "redirect:/departments";
        }
        return "redirect:/departments";
    }

    @GetMapping("/department/{deptNo}")
    String departmentDetailForm(HttpSession session, Model model, @PathVariable Long deptNo){
        if(session.getAttribute("user") != null){
            DepartmentDetailDto departmentDetailDto  = departmentDetailService.selectDepartment(deptNo);
            if(departmentDetailDto != null){
                model.addAttribute("departmentDetailDto",departmentDetailDto);
                return "department/department-detail";
            }
        }
        return "redirect:/departments";
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

    @GetMapping("/department/{deptNo}/delete")
    String departmentDelete(HttpSession session,@PathVariable Long deptNo){
        if(session.getAttribute("user").equals("admin")){
            Integer deleteDepartmentResult = departmentDeleteService.deleteDepartment(deptNo);
            System.out.println(deleteDepartmentResult);
            return "redirect:/departments";
        }

        return "redirect:/departments";
    }

    @GetMapping("/department/{deptNo}/update")
    String departmentUpdateForm(HttpSession session, Model model, @PathVariable Long deptNo){
        if(session.getAttribute("user").equals("admin")) {
            DepartmentDetailDto departmentDetailDto = departmentUpdateService.selectDepartment(deptNo);
            if(departmentDetailDto != null) {
                return getModel(model, deptNo);
            }
        }
        return "redirect:/departments";
    }

    @PostMapping("/department/{deptNo}/update")
    String departmentUpdate(HttpSession session,Model model, @PathVariable Long deptNo, @Valid DepartmentForm departmentForm, BindingResult bindingResult){
        if(session.getAttribute("user").equals("admin")) {
            DepartmentDetailDto departmentDetailDto = departmentUpdateService.selectDepartment(deptNo);
            if(departmentDetailDto != null) {
                //Valid 검증
                if (bindingResult.hasErrors()) {
                    return getModel(model, deptNo);
                }
                System.out.println(departmentForm.toString());
                System.out.println(deptNo);
                departmentForm.setDeptno(deptNo);
                Integer updateDepartmentResult = departmentUpdateService.updateDepartment(departmentForm);
                System.out.println(updateDepartmentResult);
            }

        }
        return "redirect:/departments";
    }

    private String getModel(Model model, @PathVariable Long deptNo) {
        List<EmployeeDto> findByEmployeesRelevantDepartment = departmentUpdateService.findByEmployeesRelevantDepartment(deptNo);
        List<DepartmentDto> findByAllDepartment = departmentUpdateService.findAllByDepartment();
        model.addAttribute("departmentForm", new DepartmentForm());
        model.addAttribute("findByAllDepartment", findByAllDepartment);
        model.addAttribute("findByEmployeesRelevantDepartment", findByEmployeesRelevantDepartment);
        return "/department/department-update";
    }


}
