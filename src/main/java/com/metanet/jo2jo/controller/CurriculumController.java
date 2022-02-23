package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;

import com.metanet.jo2jo.domain.educated.EducatedDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.service.curriculum.*;


import com.metanet.jo2jo.service.educated.EducatedDeleteService;
import com.metanet.jo2jo.service.educated.EducatedInsertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final CurriculumDeleteService curriculumDeleteService;
    private final EducatedInsertService educatedInsertService;
    private final EducatedDeleteService educatedDeleteService;

    //커리큘럼 메인
    @GetMapping("/curriculums")
    String curriculumMain(@ModelAttribute("params") CurriculumDto params, HttpSession session, Model model){
        if(session.getAttribute("user") != null) {
            if(session.getAttribute("user").equals("admin")){
                List<CurriculumDto> curriculumList = curriculumSelectService.curriculumList(params);
                model.addAttribute("curriculumList", curriculumList);
            }
            if(session.getAttribute("user").equals("employee")){
                List<CurriculumDto> curriculumList = curriculumSelectService.curriculumListFromEmp(params);
                model.addAttribute("curriculumList", curriculumList);
            }

            return "curriculum/curriculum-main";
        }
        return "redirect:/";
    }

    //커리큘럼 상세
    @GetMapping("/curriculum/{currno}")
    public String curriculumDetail(@PathVariable Long currno, @ModelAttribute CurriculumDto curriculum, HttpSession session, Model model) {
        if(session.getAttribute("user") != null){
            curriculum.setCurrno(currno);
            EducatedDto educatedDto = new EducatedDto();
            educatedDto.setCurrno(currno);


            CurriculumDto curriculumOne = curriculumDetailService.findOneCurriculum(curriculum).get();
            List<String> cosList = cosList(curriculumOne);

            if(session.getAttribute("user").equals("employee")){
                educatedDto.setEmpno(((EmployeeDto)(session.getAttribute("info"))).getEmpno());
                model.addAttribute("empno", ((EmployeeDto)(session.getAttribute("info"))).getEmpno());
                model.addAttribute("educatedState", educatedInsertService.findCurriculumState(educatedDto));
            }
            if(session.getAttribute("user").equals("admin")){
                educatedDto.setEmpno(((AdminDto)(session.getAttribute("info"))).getNo());
            }

            model.addAttribute("cosList",cosList);
            model.addAttribute("curriculum",curriculumOne);

            return "curriculum/curriculum-detail";
        }
        return "redirect:/";
    }

    //커리큘럼 업데이트
    @GetMapping("/curriculum/{currno}/update")
    public String curriculumUpdate(@PathVariable Long currno, HttpSession session, Model model, @ModelAttribute("curriculumDto") CurriculumDto curriculumDto) {
        if(session.getAttribute("user").equals("admin")) {
            curriculumDto.setCurrno(currno);
            model.addAttribute("curriculumDto",curriculumDetailService.findOneCurriculum(curriculumDto).get());
            if(curriculumDto != null) {
                return getModel(model, currno);
            }
        }
        return "redirect:/";
    }

    @PostMapping("/curriculum/{currno}/update")
    public String curriculumUpdateForm(@RequestParam("daterange") String daterange,
                                       HttpSession session, Model model, @PathVariable Long currno,
                                       @ModelAttribute("curriculumDto") @Valid CurriculumDto curriculumDto, BindingResult bindingResult){
        if(session.getAttribute("user").equals("admin")) {
            curriculumDto.setCurrno(currno);
            if(curriculumDto != null) {
                //Valid 검증
                if (bindingResult.hasErrors()) {
                    Map map = bindingResult.getModel(); //테스트용
                    Set keys = map.keySet();
                    Iterator it = keys.iterator();
                    while(it.hasNext()) {
                        Object key = it.next();
                        Object val = map.get(key);
                        System.out.println("에러내용 :: "+val);
                    }
                    return getModel(model, currno);
                }
                //daterange -> startdate, enddate
                String[] dateArr = daterange.split(" - ");

                //currcost 전처리
                Long newCurrcost = curriculumDto.getCurrcost() * 10000L;

                //deptrange 전처리
                String newDeptrange = curriculumDto.getDeptrange().replace(',' ,' ');  //','을 ' '으로 치환

                //educos 전처리
                List<String> educosList = cosList(curriculumDto);
                int temp = 5-educosList.size();
                for(int i=0; i<temp; i++){                      //나머지 5코스까지는 빈칸으로 채우기
                    educosList.add("");
                }

                curriculumDto.setStartdate(dateArr[0]);
                curriculumDto.setEnddate(dateArr[1]);
                curriculumDto.setCurrcost(newCurrcost);
                curriculumDto.setEducos1(educosList.get(0));
                curriculumDto.setEducos2(educosList.get(1));
                curriculumDto.setEducos3(educosList.get(2));
                curriculumDto.setEducos4(educosList.get(3));
                curriculumDto.setEducos5(educosList.get(4));

                Long updateCurriculum = curriculumUpdateService.updateCurriculum(curriculumDto);
                Long newCostotalcnt = curriculumRegisterService.registerCurriculumCostotalcnt(curriculumDto);
                return "redirect:/curriculums";
            }
        }
        return "redirect:/curriculums";
    }

    private String getModel(Model model, @PathVariable Long currno) {
        List<DepartmentDto> deptList = curriculumRegisterService.findLowestDepartment();

        model.addAttribute("deptList", deptList);
        return "curriculum/curriculum-update";
    }

    private List<String> cosList(CurriculumDto curriculumDto){
        List<String> educosList = new ArrayList<>(){{
            add(curriculumDto.getEducos1());
            add(curriculumDto.getEducos2());
            add(curriculumDto.getEducos3());
            add(curriculumDto.getEducos4());
            add(curriculumDto.getEducos5());
        }} ;
        educosList.removeAll(Arrays.asList("",null));   //1번부터 빈칸 없이 채우기
        return educosList;
    }

    //커리큘럼 등록
    @GetMapping("/curriculum/new")
    String curriculumRegisterForm(HttpSession session, Model model, @ModelAttribute("curriculumDto") CurriculumDto curriculumDto){
        if (session.getAttribute("user").equals("admin")) {
            //최하위 부서 리스트
            List<DepartmentDto> deptList = curriculumRegisterService.findLowestDepartment();
            model.addAttribute("deptList", deptList);
            return "curriculum/curriculum-register";
        } else{
            return "redirect:/";
        }
    }


    @PostMapping("/curriculum/new")
    String curriculumRegister(@RequestParam("daterange") String daterange,
                              HttpSession session, Model model, @ModelAttribute("curriculumDto") @Valid CurriculumDto curriculumDto,
                              BindingResult bindingResult)  throws IOException {
        if (session.getAttribute("user").equals("admin")) {
            //Valid 검증
            if (bindingResult.hasErrors()) {
                Map map = bindingResult.getModel(); //테스트용
                Set keys = map.keySet();
                Iterator it = keys.iterator();
                while(it.hasNext()) {
                    Object key = it.next();
                    Object val = map.get(key);
                    System.out.println("에러내용 :: "+val);
                }

                //최하위 부서 리스트
                List<DepartmentDto> deptList = curriculumRegisterService.findLowestDepartment();
                model.addAttribute("deptList", deptList);

                return "curriculum/curriculum-register";
            }

            //daterange -> startdate, enddate
            String[] dateArr = daterange.split(" - ");

            //currcost 전처리
            Long newCurrcost = curriculumDto.getCurrcost() * 10000L;

            //deptrange 전처리
            String newDeptrange = curriculumDto.getDeptrange().replace(',' ,' ');  //','을 ' '으로 치환

            //educos 전처리
            List<String> educosList = cosList(curriculumDto);
            int temp = 5-educosList.size();
            for(int i=0; i<temp; i++){                      //나머지 5코스까지는 빈칸으로 채우기
                educosList.add("");
            }

            curriculumDto.setStartdate(dateArr[0]);
            curriculumDto.setEnddate(dateArr[1]);
            curriculumDto.setCurrcost(newCurrcost);
            curriculumDto.setEducos1(educosList.get(0));
            curriculumDto.setEducos2(educosList.get(1));
            curriculumDto.setEducos3(educosList.get(2));
            curriculumDto.setEducos4(educosList.get(3));
            curriculumDto.setEducos5(educosList.get(4));

            CurriculumDto newCurriculum = curriculumRegisterService.saveCurriculum(curriculumDto);
            Long newCostotalcnt = curriculumRegisterService.registerCurriculumCostotalcnt(newCurriculum);
            return "redirect:/curriculums";
        }

        return "redirect:/";
    }

    //사원 커리큘럼 신청
    @PostMapping("/curriculum/register")
    String curriculumSignUp(HttpSession session,
                            @RequestParam("currno") Long currno,
                            RedirectAttributes redirectAttributes){
        if (session.getAttribute("user").equals("employee")) {
            EducatedDto educatedDto = new EducatedDto();
            educatedDto.setCurrno(currno);
            Long empno = ((EmployeeDto)(session.getAttribute("info"))).getEmpno();
            educatedDto.setEmpno(empno);

            educatedInsertService.signUpForClass(educatedDto);
            redirectAttributes.addAttribute("currno", currno);
            return "redirect:/curriculum/{currno}";

//            model.addAttribute("currno", currno); //redirect 안쓰고 하는 원래 방법
//            CurriculumDto curriculum = new CurriculumDto();
//            curriculum.setCurrno(currno);
//            model.addAttribute("curriculum",curriculumDetailService.findOneCurriculum(curriculum).get());
//            return "curriculum/curriculum-detail";
        }
        return "redirect:/";
    }

    //커리큘럼 삭제
    @GetMapping("/curriculum/{currno}/delete")
    public String curriculumDelete(@PathVariable Long currno, HttpSession session) {
        if(session.getAttribute("user").equals("admin")) {
            EducatedDto educatedDto = new EducatedDto();
            educatedDto.setCurrno(currno);
            educatedDto.setEmpno(-1L);

            //이수 내역 삭제
            educatedDeleteService.deleteEducated(educatedDto);
            //커리큘럼 삭제
            curriculumDeleteService.deleteCurriculum(currno);
            return "redirect:/curriculums";
        }
        return "redirect:/";
    }
}
