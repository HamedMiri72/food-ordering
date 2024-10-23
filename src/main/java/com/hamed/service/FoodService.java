package com.hamed.service;

import com.hamed.model.Category;
import com.hamed.model.Food;
import com.hamed.model.Restaurant;
import com.hamed.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    public void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegetarian, boolean isNoveg, boolean isSeasonal, String category);

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long FoodId)throws Exception;

    public Food updateAvalibilty(Long foodId) throws Exception;



}
