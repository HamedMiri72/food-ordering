package com.hamed.controller;

import com.hamed.model.Food;
import com.hamed.model.User;
import com.hamed.service.FoodService;
import com.hamed.service.RestaurantService;
import com.hamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/search")
    public ResponseEntity <List<Food>> searchFood(@RequestParam String name,
                                                  @RequestHeader ("Authorization") String jwt) throws  Exception{

        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);


    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity <List<Food>> getRestaurantFood(@RequestParam boolean vegetarian,
                                                         @RequestParam boolean seasonal,
                                                         @RequestParam boolean nonVeg,
                                                         @PathVariable Long restaurantId,
                                                         @RequestParam(required = false) String food_category,
                                                         @RequestHeader ("Authorization") String jwt) throws  Exception{

        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantsFood(restaurantId, vegetarian, nonVeg, seasonal, food_category);

        return new ResponseEntity<>(foods, HttpStatus.OK);


    }
}
