package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantInformation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantEditRepositoryImpl implements RestaurantEditRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void update(RestaurantInformation restaurantInformation){

        String sql =
                "UPDATE                 " +
                "  restaurants          " +
                "SET                    " +
                "  restaurant_name =  ?," +
                "  tagline         =  ? " +
                "WHERE                  " +
                "  restaurant_id   =  ? " ;

        jdbcTemplate.update(sql,
                restaurantInformation.getRestaurantName(),
                restaurantInformation.getTagline(),
                restaurantInformation.getRestaurantId());
    }

}
