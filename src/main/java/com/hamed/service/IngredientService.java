package com.hamed.service;

import com.hamed.model.IngredientCategory;
import com.hamed.model.IngredientItem;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IngredientService {

    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;

    public IngredientCategory findIngredientCategoryById(Long id)throws Exception;

    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

    public IngredientItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId)throws Exception;

    public List<IngredientItem> findRestaurantIngredients(Long restaurantId)throws Exception;

    public IngredientItem updateStock(Long id)throws Exception;

}
