package com.hamed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    //Because when we fetch cartitem we Don't need cart
    private Cart cart;

    @ManyToOne //many cart item have same food
    private Food food;

    private int quantity;

    private List<String> ingredients;

    private Long totalPrice;






}
