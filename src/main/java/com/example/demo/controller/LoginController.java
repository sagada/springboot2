package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public void login() {

    }
//
    @GetMapping("/loginSuccess")
    public void accessDenied(){
        log.debug("loginSuccess");
    }
//
//    @GetMapping("/logout")
//    public void logout(){
//        log.debug("accessDenied");
//    }
}
