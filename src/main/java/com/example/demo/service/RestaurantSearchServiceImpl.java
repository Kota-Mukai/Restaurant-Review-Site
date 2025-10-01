package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantSearchResult;
import com.example.demo.repository.RestaurantSearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantSearchServiceImpl implements RestaurantSearchService {

    private final RestaurantSearchRepository repository;

    @Override
    public List<RestaurantSearchResult> findByNameWildCard(String restaurantName) {
        List<RestaurantSearchResult> list
           = repository.selectByNameWildCard(restaurantName);

           return list;
    }

}
