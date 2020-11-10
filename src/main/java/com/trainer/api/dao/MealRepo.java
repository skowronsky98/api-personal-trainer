package com.trainer.api.dao;

import com.trainer.api.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MealRepo extends JpaRepository<Meal, Long> {

}
