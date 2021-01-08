package com.trainer.api.model.plan;

import com.trainer.api.model.Meal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealPlanTest {
    Meal meal = new Meal();
    String name = "Jajecznica";
    String type = "Śniadanie";

    @Test
    void createInstanceMealPlan(){

        MealPlan mealPlan = new MealPlan();
        assertNotEquals(null,mealPlan);
    }

    @Test
    void createMealPlan(){

        MealPlan mealPlan = new MealPlan();

        assertNotEquals(null,mealPlan);
    }





}