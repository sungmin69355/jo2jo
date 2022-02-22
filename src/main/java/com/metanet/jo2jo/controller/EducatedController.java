package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.curriculum.CurriculumUpdateService;
import com.metanet.jo2jo.service.educated.EducatedDeleteService;
import com.metanet.jo2jo.service.educated.EducatedSelectService;
import com.metanet.jo2jo.service.educated.EducatedUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EducatedController {
    private final EducatedUpdateService educatedUpdateService;
    private final CurriculumUpdateService curriculumUpdateService;
    private final EducatedSelectService educatedSelectService;
    private final EducatedDeleteService educatedDeleteService;

    @GetMapping("/educated")
    String updateEdustateProgress(HttpSession session,
                                  @RequestParam("edustate") Long edustate,
                                  @RequestParam("currno") Long currno,
                                  RedirectAttributes redirectAttributes,
                                  Model model){
        if(session.getAttribute("user")!=null){
            if(session.getAttribute("user").equals("employee")) {
                EducatedDto educatedDto = new EducatedDto();
                educatedDto.setCurrno(currno);
                educatedDto.setEmpno(((EmployeeDto)(session.getAttribute("info"))).getEmpno());

                CurriculumDto curriculumDto = new CurriculumDto();
                curriculumDto.setCurrno(currno);
                Long cosTotalCnt = curriculumUpdateService.findOneCurriculum(curriculumDto).get().getCostotalcnt();
                Long originEdustate = educatedSelectService.getOneEducated(educatedDto).get().getEdustate();

                if(originEdustate + edustate <= cosTotalCnt){
                    edustate = originEdustate + edustate;
                }else{
                    edustate = cosTotalCnt;
                }
                educatedDto.setEdustate(edustate);
                educatedUpdateService.updateProgressOfClass(educatedDto);

                redirectAttributes.addAttribute("empno", ((EmployeeDto)(session.getAttribute("info"))).getEmpno());

                return "redirect:/employee/{empno}";
            }
            return "redirect:curriculums";
        }
        return "redirect:/";
    }


    @GetMapping("/educated/{empno}/{currno}/delete")
    public String curriculumDelete(@PathVariable Long empno,
                                   @PathVariable Long currno,
                                   HttpSession session) {
        if(session.getAttribute("user").equals("employee")) {
            EducatedDto educatedDto = new EducatedDto();
            educatedDto.setCurrno(currno);
            educatedDto.setEmpno(empno);

            //이수 내역 삭제
            educatedDeleteService.deleteEducated(educatedDto);

            return "redirect:/curriculums";
        }
        return "redirect:/";
    }

}
