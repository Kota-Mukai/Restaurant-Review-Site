package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.RestaurantSearchResult;
import com.example.demo.form.RestaurantSearchForm;
import com.example.demo.service.RestaurantSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantSearchController {

    private final RestaurantSearchService service;

    @GetMapping("/mt-restaurant-search")
    public String restaurantSearch(
            @ModelAttribute RestaurantSearchForm form){

        return "mt-restaurant-search";
    }

    @PostMapping("/mt-restaurant-search")
    public String showSearchResult(
            @ModelAttribute RestaurantSearchForm form,
            Model model) {

        List<RestaurantSearchResult> list
           = service.findByNameWildCard(form.getRestaurantName());

        model.addAttribute("restaurantList", list);

        return "mt-restaurant-search";
        }
    

}
