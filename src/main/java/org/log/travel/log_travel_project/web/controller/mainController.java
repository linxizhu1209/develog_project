package org.log.travel.log_travel_project.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.log.travel.log_travel_project.config.auth.LoginUser;
import org.log.travel.log_travel_project.service.oauth.UserService;
import org.log.travel.log_travel_project.web.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/develog")
@Slf4j
public class mainController {

    private final UserService userService;
    @GetMapping("")
    public String mainPage(Model model, @LoginUser SessionUser user){
        if(user!=null) {
            model.addAttribute("users", user);
        }
        return "main";
    }

    @GetMapping("/write")
    public String writePage(){return "write";}
    @GetMapping("/login")
    public String loginPage(){ return "login";}

    @GetMapping("/signUp")
    public String signupPage(){ return "signup";}

    @GetMapping("/Spring")
    public String springPage(){ return "spring";}

    @GetMapping("/CodingTest")
    public String codingTestPage(){ return "codingTest";}





}
