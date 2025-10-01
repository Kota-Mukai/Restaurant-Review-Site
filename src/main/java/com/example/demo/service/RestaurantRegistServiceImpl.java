package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RestaurantInformation;
import com.example.demo.repository.RestaurantRegistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantRegistServiceImpl implements RestaurantRegistService{

    private final RestaurantRegistRepository repository;

    @Override
    public void regist(RestaurantInformation restaurantInformation){

        repository.add(restaurantInformation);
    }

}
