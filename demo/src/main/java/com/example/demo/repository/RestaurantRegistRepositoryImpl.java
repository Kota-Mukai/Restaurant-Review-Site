package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantInformation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRegistRepositoryImpl implements RestaurantRegistRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void add(RestaurantInformation restaurantInformation){

        String sql =
                "INSERT INTO restaurants" +
                "(restaurant_name, tagline)"+
                "VALUES(?,?)";

                jdbcTemplate.update(sql, restaurantInformation.getRestaurantName(),
                                         restaurantInformation.getTagline());
    }

}
