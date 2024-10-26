package com.hamed.service;

import com.hamed.model.Category;
import com.hamed.model.IngredientCategory;
import com.hamed.model.IngredientItem;
import com.hamed.model.Restaurant;
import com.hamed.repository.CategoryRepository;
import com.hamed.repository.IngredientCategoryRepository;
import com.hamed.repository.IngredientItemRepository;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImp implements IngredientService {

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private RestaurantService restaurantService;



    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {

        Restaurant restaurant = restaurantService.findResturantById(restaurantId);
        IngredientCategory ingredientCategory = new IngredientCategory();
        ingredientCategory.setName(name);
        ingredientCategory.setRestaurant(restaurant);

        return ingredientCategoryRepository.save(ingredientCategory);
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory> optionalIngredientCategory = ingredientCategoryRepository.findById(id);
        if(optionalIngredientCategory.isEmpty()){
            throw new Exception("Ingredient Category not found");
        }
        return optionalIngredientCategory.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {

        restaurantService.findResturantById(id);
        return ingredientCategoryRepository.findIngredientCategoryByRestaurantId(id);
    }

    @Override
    public IngredientItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.findResturantById(restaurantId);
        IngredientCategory category = findIngredientCategoryById(categoryId);

        IngredientItem ingredientItem = new IngredientItem();
        ingredientItem.setName(ingredientName);
        ingredientItem.setRestaurant(restaurant);
        ingredientItem.setCategory(category);


        IngredientItem ingredient = ingredientItemRepository.save(ingredientItem);
        category.getIngrediants().add(ingredient);

        return ingredient;
    }

    @Override
    public List<IngredientItem> findRestaurantIngredients(Long restaurantId) throws Exception {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientItem updateStock(Long id) throws Exception {
        Optional<IngredientItem> optionalIngredientItem = ingredientItemRepository.findById(id);

        if(optionalIngredientItem.isEmpty()){
            throw new Exception("Ingredient Item is not found");
        }

        IngredientItem ingredientItem = optionalIngredientItem.get();
        ingredientItem.setStoke(!ingredientItem.isStoke());

        return ingredientItemRepository.save(ingredientItem);
    }
}
