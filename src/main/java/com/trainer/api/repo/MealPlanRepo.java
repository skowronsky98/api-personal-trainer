package com.trainer.api.repo;

import com.trainer.api.model.Meal;
import com.trainer.api.model.plan.MealPlan;

public interface MealPlanRepo {
    MealPlan addMealPlan(MealPlan mealPlan);
    void deleteMealPlan(MealPlan mealPlan);
}
