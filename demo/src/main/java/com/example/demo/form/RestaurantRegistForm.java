package com.example.demo.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestaurantRegistForm {

    @Size(min = 1, max = 32, message = "Please enter a store name between 1 and 32 characters.")
    private String restaurantName;

    @Size(min = 1, max = 64, message = "Please enter a tagline between 1 and 64 characters.")
    private String tagline;

}
