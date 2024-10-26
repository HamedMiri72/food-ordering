package com.hamed.repository;

import com.hamed.model.IngredientItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientItemRepository extends JpaRepository<IngredientItem, Long> {

}

