package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantInformation;
import com.example.demo.repository.RestaurantEditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantEditServiceImpl implements RestaurantEditService{

    private final RestaurantEditRepository repository;

    @Override
    public void edit(RestaurantInformation restaurantInformation) {

        repository.update(restaurantInformation);
    }

}
