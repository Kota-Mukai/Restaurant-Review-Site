package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/mt-top")
    public String mtTop(){
        return "mt-top";
    }

    @GetMapping("/complete")
    public String complete(){
        return "complete";
    }

}
