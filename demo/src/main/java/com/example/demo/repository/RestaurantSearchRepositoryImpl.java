package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantSearchResult;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantSearchRepositoryImpl implements RestaurantSearchRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<RestaurantSearchResult> selectByNameWildCard(String restaurantName){

        String sql =
				"SELECT                                                " +
		        "res.restaurant_id,                                    " +
				"res.restaurant_name,                                  " +
		        "res.tagline,                                          " +
				"COALESCE(COUNT(rev.review_id), 0) number_of_review    " +
		        "FROM                                                  " +
		        "restaurants res                                       " +
		        "LEFT OUTER JOIN review rev                            " +
		        "             ON res.restaurant_id = rev.restaurant_id " +
		        "WHERE                                                 " +
		        "res.restaurant_name LIKE ?                            " +
		        "GROUP BY                                              " +
		        "res.restaurant_id,                                    " +
		        "res.restaurant_name,                                  " +
		        "res.tagline                                           " +
		        "ORDER BY                                              " +
		        "res.restaurant_id                                     " ;
		
		String p = "%" + restaurantName + "%";
		
		List<Map<String, Object>> list
		        = jdbcTemplate.queryForList(sql, p); 
		
		
		
		List<RestaurantSearchResult> result = new ArrayList<RestaurantSearchResult>();
		for (Map<String, Object> one : list) {
			RestaurantSearchResult rsr = new RestaurantSearchResult();
			
			rsr.setRestaurantId((int)one.get("restaurant_id"));
			rsr.setRestaurantName((String)one.get("restaurant_name"));
			rsr.setTagline((String)one.get("tagline"));
			rsr.setNumberOfReview(((Long)one.get("number_of_review")).intValue());
			
			result.add(rsr);
		}
		        
		return result;
	}

    

}