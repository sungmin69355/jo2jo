package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;

import com.metanet.jo2jo.service.curriculum.CurriculumDetailService;

import com.metanet.jo2jo.service.curriculum.CurriculumRegisterService;
import com.metanet.jo2jo.service.curriculum.CurriculumSelectService;


import com.metanet.jo2jo.service.curriculum.CurriculumUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CurriculumController {
    private final CurriculumRegisterService curriculumRegisterService;
    private final CurriculumSelectService curriculumSelectService;
    private final CurriculumDetailService curriculumDetailService;
    private final CurriculumUpdateService curriculumUpdateService;

    //커리큘럼 메인
    @GetMapping("/curriculums")
    String curriculumMain(@ModelAttribute("params") CurriculumDto params, HttpSession session, Model model){
        if(session.getAttribute("user") != null) {
            List<CurriculumDto> curriculumList = curriculumSelectService.curriculumList(params);
            model.addAttribute("curriculumList", curriculumList);
            return "curriculum/curriculum-main";
        }
        return "redirect:/";
    }

    //커리큘럼 상세
    @GetMapping("/curriculum/{currno}")
    public String curriculumDetail(@PathVariable Long currno, @ModelAttribute CurriculumDto curriculum, HttpSession session, Model model) {
        if(session.getAttribute("user") != null){
            curriculum.setCurrno(currno);
            System.out.println(curriculumDetailService.findOneCurriculum(curriculum).toString());
            model.addAttribute("curriculum",curriculumDetailService.findOneCurriculum(curriculum).get());

            return "curriculum/curriculum-detail";
        }
        return "redirect:/";
    }

    //커리큘럼 업데이트
    @GetMapping("/curriculum/{currno}/update")
    public String curriculumUpdate(@PathVariable Long currno, HttpSession session, Model model) {
        if(session.getAttribute("user").equals("admin")) {
            CurriculumDto curriculumDto = new CurriculumDto();
            curriculumDto.setCurrno(currno);
            model.addAttribute("curriculum",curriculumDetailService.findOneCurriculum(curriculumDto).get());
            if(curriculumDto != null) {
                return getModel(model, currno);
            }
        }
        return "redirect:/";
    }

    @PostMapping("/curriculum/{currno}/update")
    public String curriculumUpdateForm(@ModelAttribute CurriculumDto curriculum,
                                       @RequestParam("daterange") String daterange,
                                       HttpSession session, Model model, @PathVariable Long currno, @Valid CurriculumDto curriculumForm, BindingResult bindingResult){
        if(session.getAttribute("user").equals("admin")) {
            curriculumForm.setCurrno(currno);
            CurriculumDto curriculumDto = curriculumUpdateService.findOneCurriculum(curriculumForm).get();
            if(curriculumDto != null) {
                //Valid 검증
                if (bindingResult.hasErrors()) {
                    return getModel(model, currno);
                }
                //daterange -> startdate, enddate
                String[] dateArr = daterange.split(" - ");

                //currcost 전처리
                Long newCurrcost = curriculum.getCurrcost() * 10000L;

                //deptrange 전처리
                String newDeptrange = curriculum.getDeptrange().replace(',' ,' ');  //','을 ' '으로 치환

                //educos 전처리
                List<String> educosList = new ArrayList<>(){{
                    add(curriculum.getEducos1());
                    add(curriculum.getEducos2());
                    add(curriculum.getEducos3());
                    add(curriculum.getEducos4());
                    add(curriculum.getEducos5());
                }} ;
                educosList.removeAll(Arrays.asList("",null));
                int temp = 5-educosList.size();
                for(int i=0; i<temp; i++){
                    educosList.add("");
                }

                curriculum.setStartdate(dateArr[0]);
                curriculum.setEnddate(dateArr[1]);
                curriculum.setCurrcost(newCurrcost);
                curriculum.setEducos1(educosList.get(0));
                curriculum.setEducos2(educosList.get(1));
                curriculum.setEducos3(educosList.get(2));
                curriculum.setEducos4(educosList.get(3));
                curriculum.setEducos5(educosList.get(4));

                curriculumUpdateService.updateCurriculum(curriculum);
                Long newCostotalcnt = curriculumUpdateService.updateCurriculumCostotalcnt(curriculum);
                return "curriculums";
            }
        }

        return "redirect:/curriculums";
    }

    private String getModel(Model model, @PathVariable Long currno) {
        CurriculumDto curriculum = new CurriculumDto();
        curriculum.setCurrno(currno);
        curriculum = curriculumUpdateService.findOneCurriculum(curriculum).get();
        List<DepartmentDto> deptList = curriculumRegisterService.findLowestDepartment();

        model.addAttribute("deptList", deptList);
        model.addAttribute("curriculumForm", new CurriculumDto());
        model.addAttribute("curriculum", curriculum);
        return "/curriculum/curriculum-update";
    }

    //커리큘럼 등록
    @GetMapping("/curriculum/new")
    String curriculumRegisterForm(HttpSession session, Model model){
        if (session.getAttribute("user").equals("admin")) {
            //최하위 부서 리스트
            List<DepartmentDto> deptList = curriculumRegisterService.findLowestDepartment();

            model.addAttribute("deptList", deptList);
            model.addAttribute("curriculumDto", new CurriculumDto());

            return "curriculum/curriculum-register";
        } else{
            return "redirect:/";
        }
    }


    @PostMapping("/curriculum/new")
    String curriculumRegister(@ModelAttribute CurriculumDto curriculum,
                              @RequestParam("daterange") String daterange,
                              HttpSession session, Model model, @ModelAttribute("curriculumDto") @Valid CurriculumDto curriculumDto,
                              BindingResult bindingResult)  throws IOException {
        if (session.getAttribute("user").equals("admin")) {
            //Valid 검증
            if (bindingResult.hasErrors()) {
                //최하위 부서 리스트
                List<DepartmentDto> deptList = curriculumRegisterService.findLowestDepartment();

                model.addAttribute("deptList", deptList);
                model.addAttribute("curriculumDto", new CurriculumDto());

                return "curriculum/curriculum-register";
            }

            //daterange -> startdate, enddate
            String[] dateArr = daterange.split(" - ");

            //currcost 전처리
            Long newCurrcost = curriculum.getCurrcost() * 10000L;

            //deptrange 전처리
            String newDeptrange = curriculum.getDeptrange().replace(',' ,' ');  //','을 ' '으로 치환

            //educos 전처리
            List<String> educosList = new ArrayList<>(){{
                add(curriculum.getEducos1());
                add(curriculum.getEducos2());
                add(curriculum.getEducos3());
                add(curriculum.getEducos4());
                add(curriculum.getEducos5());
            }} ;
            educosList.removeAll(Arrays.asList("",null));
            int temp = 5-educosList.size();
            for(int i=0; i<temp; i++){
                educosList.add("");
            }

            curriculum.setStartdate(dateArr[0]);
            curriculum.setEnddate(dateArr[1]);
            curriculum.setCurrcost(newCurrcost);
            curriculum.setEducos1(educosList.get(0));
            curriculum.setEducos2(educosList.get(1));
            curriculum.setEducos3(educosList.get(2));
            curriculum.setEducos4(educosList.get(3));
            curriculum.setEducos5(educosList.get(4));

            CurriculumDto newCurriculum = curriculumRegisterService.saveCurriculum(curriculum);
            Long newCostotalcnt = curriculumRegisterService.registerCurriculumCostotalcnt(newCurriculum);
            return "curriculums";
        }

        return "redirect:/";
    }


}
