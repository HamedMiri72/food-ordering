package com.hamed.service;

import com.hamed.dto.RestaurantDto;
import com.hamed.model.Restaurant;
import com.hamed.model.User;
import com.hamed.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

        public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

        public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception;

        public void deleteResturant(Long restaurantId) throws Exception;

        public List<Restaurant> getAllResturant();

        public List<Restaurant> searchRestaurant(String keyword);

        public Restaurant findResturantById(Long id) throws Exception;

        public Restaurant getRestaurantByUserId(Long userId) throws Exception;

        public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;

        public Restaurant updateRestaurantStatus(Long id) throws Exception;





}
