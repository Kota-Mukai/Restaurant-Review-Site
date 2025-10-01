package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSearchResult {

    private int restaurantId;
    private String restaurantName;
    private String tagline;
    private int numberOfReview;

}
