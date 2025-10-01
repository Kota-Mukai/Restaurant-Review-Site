package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantInformation;
import com.example.demo.repository.RestaurantDeleteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantDeleteServiceImpl implements RestaurantDeleteService{

    private final RestaurantDeleteRepository repository;

    @Override
    public void delete(RestaurantInformation restaurantInformation) {

        repository.remove(restaurantInformation);
    }

}
