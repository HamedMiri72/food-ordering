package com.hamed.controller;

import com.hamed.model.Food;
import com.hamed.model.Restaurant;
import com.hamed.model.User;
import com.hamed.request.CreateFoodRequest;
import com.hamed.response.MessageResponse;
import com.hamed.service.FoodService;
import com.hamed.service.RestaurantService;
import com.hamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(), restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("food deleted successfully");

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updatFoodAvailability(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvalibilty(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }
}
