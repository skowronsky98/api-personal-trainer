package com.trainer.api.repo.impl;

import com.trainer.api.manager.MealPlanManager;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.repo.MealPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealPlanImpl implements MealPlanRepo {

    @Autowired
    private MealPlanManager mealPlanManager;

    @Override
    public void deleteMealPlan(MealPlan mealPlan) {
        mealPlanManager.delete(mealPlan);
    }

    @Override
    public MealPlan addMealPlan(MealPlan mealPlan) {
        return mealPlanManager.save(mealPlan);
    }
}
