package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantInformation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantDeleteRepositoryImpl implements RestaurantDeleteRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void remove(RestaurantInformation restaurantInformation){

        String sql =
                "DELETE            " +
                "FROM              " +
                "  restaurants     " +
                "WHERE             " +
                "restaurant_id = ? ";

        jdbcTemplate.update(sql,
                restaurantInformation.getRestaurantId());
    }

}
