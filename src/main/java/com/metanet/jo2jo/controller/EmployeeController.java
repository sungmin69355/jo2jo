package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.curriculum.CurriculumDto;
import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.repository.Educated.EducatedRepository;
import com.metanet.jo2jo.service.educated.EducatedSelectService;
import com.metanet.jo2jo.service.employee.EmployeeDeleteService;
import com.metanet.jo2jo.service.employee.EmployeeRegisterService;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.domain.employee.EmployeeUpdateForm;
import com.metanet.jo2jo.service.employee.EmployeeSelectService;
import com.metanet.jo2jo.service.employee.EmployeeUpdateService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:/common.properties")
public class EmployeeController {
    private final EmployeeSelectService employeeService;
    private final EmployeeRegisterService employeeRegisterService;
    private final EmployeeUpdateService employeeUpdateService;
    private final EducatedSelectService educatedSelectService;
    private final EmployeeDeleteService employeeDeleteService;

    //사원조회 부서추가
    @GetMapping("/employees")
    String employeeMain(HttpSession session, @ModelAttribute("params")  EmployeeSelectDto params, Model model) {
    	if(session.getAttribute("user").equals("admin") || session.getAttribute("user").equals("employee")) {
    		 model.addAttribute("employeelist", employeeService.employeeList(params));
    	        return "employee/employee-main";
    	} else {
    		  session.invalidate();
    		  return "redirect:index";
    	}
       

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
        	
        	session.invalidate();
            return "redirect:index";
        }
    }

    // 파일 저장할 위치
    @Value("${file.path}")
    private String savePath;

    //사원 등록
    @PostMapping("/employee")
    String employeeRegister(HttpSession session, Model model, @RequestParam(name="file", required = false) MultipartFile file, @Valid EmployeeRegisterForm employeeRegisterForm, BindingResult bindingResult) throws IOException {

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
            if( !file.isEmpty() ) {   //---파일이 없으면 true를 리턴. false일 경우에만 처리함.
                String uuid = UUID.randomUUID().toString()+".jpg";
                File converFile = new File(savePath, uuid);
                file.transferTo(converFile);  //--- 저장할 경로를 설정 해당 경로는 각자 원하는 위치로 설정하면 됩니다. 다만, 해당 경로에 접근할 수 있는 권한이 없으면 에러 발생
                employeeRegisterForm.setPhotoaddr(uuid);
                Integer insertEmployeeResult = employeeRegisterService.insertEmployee(employeeRegisterForm);
                System.out.println(insertEmployeeResult);
            }else{
                //공동이미지 삽입
                employeeRegisterForm.setPhotoaddr("/images/user/aaa.jpg");
                Integer insertEmployeeResult = employeeRegisterService.insertEmployee(employeeRegisterForm);
                System.out.println(insertEmployeeResult);
            }
            //결과
            return "redirect:employees";
        }
        return "redirect:index";
    }




   
  //사원조회 상세페이지
    @GetMapping("/employeedetail")
     String employeeDetail(HttpSession session, @ModelAttribute("params") EmployeeSelectDto params, @ModelAttribute("employeeDetailDto")EmployeeDetailDto employeeDetailDto,Model model) {    	
    	model.addAttribute("employeedetaillist", employeeService.employeeDetailList(params));
    	model.addAttribute("educatedlist",educatedSelectService.selectEducated(employeeDetailDto));
        return "employee/employee-detail";

       
    }
    
  //사원수정(수정페이지)
    @GetMapping("/employeeupdate")
     String employeeUpdateForm(HttpSession session, @ModelAttribute("params") EmployeeSelectDto params, Model model) {
    	model.addAttribute("employeedetaillist", employeeService.employeeDetailList(params));
    	
    	if (session.getAttribute("user").equals("admin")) {
    		
    		//부서 정보
            List<DepartmentDto> findByAllDepartment = employeeUpdateService.findAllByDepartment();
            //직급 정보
            List<PositionDto> findAllByPosition = employeeUpdateService.findAllByPosition();
            model.addAttribute("findByAllDepartment", findByAllDepartment);
            model.addAttribute("findAllByPosition", findAllByPosition);
            model.addAttribute("employeeUpdateForm", new EmployeeUpdateForm());
            return "employee/employee-update";
        } else {
            return "redirect:/employeeupdate";
        }
          
    }
    //사원 수정
    @PostMapping("/employeeupdate")
    String employeeUpdate(HttpSession session, Model model, @RequestParam(name="file", required = false) MultipartFile file, @Valid EmployeeUpdateForm  employeeUpdateForm, BindingResult bindingResult) throws IOException {

        if (session.getAttribute("user").equals("admin")) {
            System.out.println(employeeUpdateForm.toString());
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
                //부서 정보
                List<DepartmentDto> findByAllDepartment = employeeUpdateService.findAllByDepartment();
                //직급 정보
                List<PositionDto> findAllByPosition = employeeUpdateService.findAllByPosition();
                model.addAttribute("findByAllDepartment", findByAllDepartment);
                model.addAttribute("findAllByPosition", findAllByPosition);
                return "employee/employee-update";
            }
            //update 로직
            if( !file.isEmpty() ) {   //---파일이 없으면 true를 리턴. false일 경우에만 처리함.
                String uuid = UUID.randomUUID().toString()+".jpg";
                File converFile = new File(savePath, uuid);
                file.transferTo(converFile);  //--- 저장할 경로를 설정 해당 경로는 각자 원하는 위치로 설정하면 됩니다. 다만, 해당 경로에 접근할 수 있는 권한이 없으면 에러 발생
                employeeUpdateForm.setPhotoaddr(uuid);
                Integer updateEmployeeResult = employeeUpdateService.updateEmployee(employeeUpdateForm);
                System.out.println(updateEmployeeResult);
            }else{
                //공동이미지 삽입
            	employeeUpdateForm.setPhotoaddr("/images/user/aaa.jpg");
                Integer updateEmployeeResult = employeeUpdateService.updateEmployee(employeeUpdateForm);
                System.out.println(updateEmployeeResult);
            }
            //결과
            return "redirect:employees";
        }
        return "redirect:index";
    }

    @GetMapping("/employee/{empno}/delete")
    String employeeDelete(HttpSession session, Model model, @PathVariable Long empno){
        if (session.getAttribute("user").equals("admin")) {
            //커리큘럼삭제
            Integer deleteEmployeeEducated = employeeDeleteService.deleteEmployeeEducated(empno);
            //사원삭제
            Integer deleteEmployee = employeeDeleteService.deleteEmployee(empno);
            //부서 매니저정보 있으면 삭제
            Integer deleteManagerDepartment = employeeDeleteService.deleteManagerDepartment(empno);
            return "redirect:/employees";
        }
        return "redirect:/employees";
    }
    
      
}
