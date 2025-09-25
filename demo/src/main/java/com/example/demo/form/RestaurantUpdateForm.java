package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class RestaurantUpdateForm {

    @NotNull(message = "Please enter the restaurant ID.")
    @Min(value = 1, message = "Please enter a positive integer for the restaurant ID.")
    private int restaurantId;

    @NotNull(message = "Please enter the restaurant name.")
    @Size(min = 1, max = 32, message = "Please enter a restaurant name between 1 and 32 characters.")
    private String restaurantName;

    @NotNull(message = "Please enter the tagline.")
    @Size(min = 1, max = 64, message = "Please enter a tagline between 1 and 64 characters.")
    private String tagline;

}
