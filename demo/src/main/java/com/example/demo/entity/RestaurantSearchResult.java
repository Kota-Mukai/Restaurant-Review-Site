package com.example.demo.entity;

import lombok.Data;

@Data
public class RestaurantSearchResult {

    private int restaurantId;
    private String restaurantName;
    private String tagline;
    private int numberOfReview;

}
