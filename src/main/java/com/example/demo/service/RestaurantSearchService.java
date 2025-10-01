package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.RestaurantSearchResult;

public interface RestaurantSearchService {

    List<RestaurantSearchResult> findByNameWildCard(String restaurantName);

}
