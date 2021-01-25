package com.trainer.api.model.plan;

import com.trainer.api.model.Meal;
import com.trainer.api.model.user.Trainer;
import org.junit.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class WeekPlanTest {
    @Test
    public void AddDailyPlanToWeekPlanAndCheckIt() {

        Meal meal = new Meal((long) 1, "scrambled eggs", "two eggs", "recipe", 200);
        MealPlan mealPlan = new MealPlan("Reduction", meal, "breakfast");
        DailyPlan dailyPlan = new DailyPlan();
        dailyPlan.setName("reduction");
        dailyPlan.setNumberOfDay(15);
        dailyPlan.addMealPlan(mealPlan);

        Trainer trainer = new Trainer();
        WeekPlan weekPlan = new WeekPlan(5);
        weekPlan.set_id("1");
        weekPlan.setTrainer(trainer);
        weekPlan.addDailyPlan(dailyPlan);

        Collection<DailyPlan> plans = weekPlan.getDailyPlans();

        assertEquals(dailyPlan, plans.stream().filter(p->p.equals(dailyPlan)).findAny().orElse(null));
    }

    @Test
    public void DailyPlanNullCheck() {
        WeekPlan weekPlan = new WeekPlan(4);

        assertNotEquals(null, weekPlan.getDailyPlans());
    }
}