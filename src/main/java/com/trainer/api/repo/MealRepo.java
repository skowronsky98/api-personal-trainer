package com.trainer.api.repo;

import com.trainer.api.model.Meal;

import java.util.Collection;

public interface MealRepo {
    Meal addMeal(Meal meal,String idTrainer);
    Collection<Meal> getAllMeals(String idTrainer);
    void deleteMeal(Meal meal,String idTrainer);
}
