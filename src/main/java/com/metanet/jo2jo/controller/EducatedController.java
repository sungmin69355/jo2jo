package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.curriculum.CurriculumUpdateService;
import com.metanet.jo2jo.service.educated.EducatedSelectService;
import com.metanet.jo2jo.service.educated.EducatedUpdateService;
import com.metanet.jo2jo.service.employee.EmployeeSelectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EducatedController {
    private final EducatedUpdateService educatedUpdateService;
    private final EducatedSelectService educatedSelectService;
    private final CurriculumUpdateService curriculumUpdateService;
    private final EmployeeSelectService employeeSelectService;

    @GetMapping("educated")
    String updateEdustateProgress(HttpSession session,
                                  @RequestParam("edustate") Long edustate,
                                  @RequestParam("currno") Long currno,
                                  Model model){
        if(session.getAttribute("user")!=null){
            if(session.getAttribute("employee").equals("employee")) {
                EducatedDto educatedDto = new EducatedDto();
                educatedDto.setEdustate(edustate);
                educatedDto.setCurrno(currno);
                educatedUpdateService.updateProgressOfClass(educatedDto);
                System.out.println("edustate: "+edustate);
                System.out.println("currno: "+currno);

                EmployeeSelectDto employeeSelectDto = new EmployeeSelectDto();
                employeeSelectDto.setEmpno(((EmployeeDto)(session.getAttribute("info"))).getEmpno());

                EmployeeDetailDto employeeDetailDto = new EmployeeDetailDto();
                employeeDetailDto.setEmpno(((EmployeeDto)(session.getAttribute("info"))).getEmpno());

                model.addAttribute("employeedetaillist", employeeSelectService.employeeDetailList(employeeSelectDto));
                model.addAttribute("educatedlist",educatedSelectService.selectEducated(employeeDetailDto));
                return "employee/employee-detail";
            }
            return "redirect:/curriculums";
        }
        return "redirect:/";
    }

}
