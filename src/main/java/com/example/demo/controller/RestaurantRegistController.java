package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.RestaurantInformation;
import com.example.demo.form.RestaurantRegistForm;
import com.example.demo.service.RestaurantRegistService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class RestaurantRegistController {

    private final RestaurantRegistService service;

    @GetMapping("/restaurant-regist")
    public String accessRestaurantRegist(
        @ModelAttribute RestaurantRegistForm form) {

        return "restaurant-regist";
    }

    @PostMapping("/restaurant-regist")
    public String RestaurantRegist(
             @Validated @ModelAttribute RestaurantRegistForm form,
             BindingResult result) {

        if (result.hasErrors()) {
            return "restaurant-regist";
        }

        return "confirm-restaurant-regist";
    }

    @PostMapping("/restaurant-regist-ret")
    public String RestaurantRegistRet(@ModelAttribute RestaurantRegistForm form){

        return "restaurant-regist";

    }

    @PostMapping("/confirm-restaurant-regist")
    public String confirmRestaurantRegist(
            @Validated RestaurantRegistForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        
        if(result.hasErrors()){
            return "restaurant-regist";
        }

        RestaurantInformation rr = new RestaurantInformation();
        rr.setRestaurantName(form.getRestaurantName());
        rr.setTagline(form.getTagline());
        service.regist(rr);

        redirectAttributes.addFlashAttribute("msg", "New Restaurant Registration");

        return "redirect:/complete";

    }   
}