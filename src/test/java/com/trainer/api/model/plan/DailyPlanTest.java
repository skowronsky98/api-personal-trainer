package com.trainer.api.model.plan;



import com.trainer.api.model.Meal;
import org.junit.Test;


import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DailyPlanTest {




    @Test
    public void AddMealPlanToDailyPlanAndCheck() {
        DailyPlan dailyPlan = new DailyPlan();
        dailyPlan.setName("reduction");
        dailyPlan.setNumberOfDay(15);
        Meal meal = new Meal((long) 1,"scrambled eggs","two eggs", "recipe", 200);
        MealPlan mealPlan = new MealPlan("Reduction", meal, "breakfast");
        dailyPlan.addMealPlan(mealPlan);

        Collection<MealPlan> plans = dailyPlan.getMealPlans();

        assertEquals(mealPlan, plans.stream().filter(p->p.equals(mealPlan)).findAny().orElse(null));
    }


}