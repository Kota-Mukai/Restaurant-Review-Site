package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.RestaurantInformation;
import com.example.demo.form.RestaurantUpdateForm;
import com.example.demo.service.RestaurantDeleteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantDeleteController {

    private final RestaurantDeleteService service;

    @PostMapping("/delete-restaurant")
    public String deleteRestaurant(@Validated @ModelAttribute
            RestaurantUpdateForm form,
            BindingResult result){

        if(result.hasErrors()){
            return "ad-shop-search";
        }

        return "confirm-delete-restaurant";

    }

    @PostMapping("/confirm-delete-restaurant")
    public String confirmDeleteRestaurant(@Validated
            RestaurantUpdateForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes){

        if(result.hasErrors()) {
            return "ad-shop-search";
        }
        
        RestaurantInformation rd = new RestaurantInformation();
        rd.setRestaurantId(form.getRestaurantId());
        rd.setRestaurantName(form.getRestaurantName());
        rd.setTagline(form.getTagline());

        service.delete(rd);

    redirectAttributes.addFlashAttribute("msg", "Delete restaurant information.");
    
    return "redirect:/complete";

    }

}