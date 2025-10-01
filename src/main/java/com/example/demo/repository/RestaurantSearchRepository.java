package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.RestaurantSearchResult;

public interface RestaurantSearchRepository {

    List<RestaurantSearchResult> selectByNameWildCard(String restaurantName);

}
