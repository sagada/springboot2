package com.example.demo.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
public class SampleController {

    @GetMapping("/sample1")
    public void sample1(Model model)
    {
        model.addAttribute("greeting", "Hello World");
    }

    @GetMapping("/")
    public String index()
    {
        log.info("index");
        return "index";
    }

    @RequestMapping("/guest")
    public void forGuest()
    {
        log.info("guest");
    }

    @RequestMapping("/manager")
    public void forManager()
    {
        log.info("manager");
    }

    @RequestMapping("/admin")
    public void forAdmin()
    {
        log.info("admin");
    }
}
