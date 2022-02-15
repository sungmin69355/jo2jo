package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.department.DepartmentDto;
import com.metanet.jo2jo.domain.employee.EmployeeDetailDto;
import com.metanet.jo2jo.domain.employee.EmployeeRegisterForm;
import com.metanet.jo2jo.domain.position.PositionDto;
import com.metanet.jo2jo.service.EmployeeRegisterService;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.metanet.jo2jo.domain.employee.EmployeeSelectDto;
import com.metanet.jo2jo.service.EmployeeSelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:/common.properties")
public class EmployeeController {
    private final EmployeeSelectService employeeService;
    private final EmployeeRegisterService employeeRegisterService;

    //사원조회 부서추가
    @GetMapping("/employees")
    String employeeMain(@ModelAttribute("params") EmployeeSelectDto params, Model model) {
        model.addAttribute("employeelist", employeeService.employeeList(params));
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
     String employeeDetail(@ModelAttribute("params") EmployeeSelectDto params, Model model) {    	
    	model.addAttribute("employeedetaillist", employeeService.employeeDetailList(params));
        return "employee/employee-detail";
       
    }

}
