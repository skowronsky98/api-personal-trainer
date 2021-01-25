package com.trainer.api.model.plan;

import com.trainer.api.model.Meal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealPlanTest {
    String name = "Jajecznica";
    Meal meal = new Meal((long) 1,name,"two eggs", "recipe", 200);


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

    @Test
    void checkMealInMealPlan() {
        MealPlan mealPlan = new MealPlan("Reduction", meal, "breakfast");
        assertEquals("breakfast", mealPlan.getType());
        assertEquals(meal, mealPlan.getMeal());
    }







}