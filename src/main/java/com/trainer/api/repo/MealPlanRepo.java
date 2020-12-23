package com.trainer.api.repo;

import com.trainer.api.model.Meal;
import com.trainer.api.model.plan.MealPlan;

public interface MealPlanRepo {
    MealPlan createMealPlan(MealPlan mealPlan, String idTrainer);
    void deleteMealPlan(MealPlan mealPlan);
    MealPlan getMealPlanById(String idMealPlan);
    void deleteMealPlanById(String idMealPlan);
}
