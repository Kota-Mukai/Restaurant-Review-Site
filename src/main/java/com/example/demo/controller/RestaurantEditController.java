package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.RestaurantInformation;
import com.example.demo.form.RestaurantUpdateForm;
import com.example.demo.service.RestaurantEditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantEditController {

    private final RestaurantEditService service;

    @PostMapping("/show-edit-restaurant-form")
    public String showEditForm(@ModelAttribute RestaurantUpdateForm form) {

        return "edit-restaurant";
    }

    @PostMapping("/edit-restaurant")
    public String editRestaurant(
        @Validated @ModelAttribute RestaurantUpdateForm form,
        BindingResult result) {

        if(result.hasErrors()) {
            return "edit-restaurant";
        }

        return "confirm-edit-restaurant";

    }
    

    @PostMapping("/confirm-edit-restaurant")
    public String confirmEditRestaurant(
            @Validated RestaurantUpdateForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "edit-restaurant";
        }

        RestaurantInformation re = new RestaurantInformation();
        re.setRestaurantId(form.getRestaurantId());
        re.setRestaurantName(form.getRestaurantName());
        re.setTagline(form.getTagline());

        service.edit(re);

        redirectAttributes.addFlashAttribute("msg" , "Edit restaurnat information");

        return "redirect:/complete";

    }
    
}