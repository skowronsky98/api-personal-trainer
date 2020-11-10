package com.trainer.api.service;

import com.trainer.api.dao.MealDao;
import com.trainer.api.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MealService {
    @Autowired
    private MealDao mealDao;

    public Collection<Meal> getMeals() {
        return mealDao.getMeals();
    }

    public Meal addMeal(Meal meal){
        return mealDao.addMeal(meal);
    }

}
