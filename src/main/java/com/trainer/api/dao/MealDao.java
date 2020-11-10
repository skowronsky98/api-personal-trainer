package com.trainer.api.dao;

import com.trainer.api.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MealDao {

    @Autowired
    private MealRepo mealRepo;

    public Collection<Meal> getMeals(){
        return mealRepo.findAll();
    }

    public Meal addMeal(Meal meal){
        return mealRepo.save(meal);
    }
}
