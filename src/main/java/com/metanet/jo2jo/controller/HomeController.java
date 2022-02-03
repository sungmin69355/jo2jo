package com.metanet.jo2jo.controller;

import com.metanet.jo2jo.domain.Login.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @GetMapping("/")
    String home(Model model, HttpSession session){
        model.addAttribute("loginDto", new LoginDto());
        if (session != null) {
            return "login/main";
        }
        return "index";
    }

    @GetMapping("/1")
    String home1(){
        return "accordion";
    }
    
    //ui제작 테스트용
    @GetMapping("/employee")
    String employeeMain() {
        return "employee/employee-main";
    }
    
  //ui제작 테스트용
    @GetMapping("/department")
    String departmentRegister() {
        return "department/department-register";
    }


    @GetMapping("/accordion")
    public String accordion(){
        return "accordion"; 
    }
    @GetMapping("/button")
    public String button(){
        return "button";
    }
    @GetMapping("/label-badge")
    public String labelbadge(){
        return "label-badge";
    }
    @GetMapping("/grid-system")
    public String gridsystem(){
        return "bootstrap-ui";
    }
    @GetMapping("/box-shadow")
    public String boxshadow(){
        return "box-shadow";
    }
    @GetMapping("/color")
    public String color(){
        return "color";
    }
    @GetMapping("/light-box")
    public String lightbox(){
        return "light-box";
    }
    @GetMapping("/notification")
    public String notification(){
        return "notification";
    }
    @GetMapping("/panels-wells")
    public String panelswells(){
        return "panels-wells";
    }
    @GetMapping("/tabs")
    public String tabs(){
        return "tabs";
    }
    @GetMapping("/tooltips")
    public String tooltips(){
        return "tooltips";
    }
    @GetMapping("/typography")
    public String typography(){
        return "typography";
    }
    @GetMapping("/float-chart")
    public String floatchart(){
        return "float-chart";
    }
    @GetMapping("/morris-chart")
    public String morrischart(){
        return "morris-chart";
    }
    @GetMapping("/form-elements-bootstrap")
    public String formElementsBootstrap(){
        return "form-elements-bootstrap";
    }
    @GetMapping("/form-elements-advance")
    public String formElementsAdvance(){
        return "form-elements-advance";
    }
    @GetMapping("/basic-table")
    public String basictable(){
        return "basic-table";
    }
    @GetMapping("/login1")
    public String login1(){
        return "login1";
    }
    @GetMapping("register1")
    public String register1(){
        return "register1";
    }
    @GetMapping("/forgot-password")
    public String forgotPassword(){
        return "forgot-password";
    }
    @GetMapping("/404")
    public String fourZeroFour(){
        return "404";
    }
    @GetMapping("/sample-page")
    public String samplePage(){
        return "sample-page";
    }
}
