package com.trainer.api.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MealTest {

    @Test
    public void CheckMealEqual(){
        Meal meal = new Meal(1l,"soup", "eggs", "cook", 50d);

        assertEquals(50d, meal.getKcal());
    }

    @Test
    public void CheckMealNotEqual(){
            Meal meal = new Meal(1l,"soup", "eggs", "cook", 50d);

            assertNotEquals(40d, meal.getKcal());
        }
}