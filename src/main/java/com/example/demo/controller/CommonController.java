package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/ad-top")
    public String mtTop(){
        return "ad-top";
    }

    @GetMapping("/complete")
    public String complete(){
        return "complete";
    }

}
