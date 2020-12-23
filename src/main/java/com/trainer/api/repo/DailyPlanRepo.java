package com.trainer.api.repo;

import com.trainer.api.model.plan.DailyPlan;

public interface DailyPlanRepo {
    DailyPlan createDailyPlan(DailyPlan dailyPlan, String idTrainer);
    void deleteDailyPlan(String idDailyPlan);
    DailyPlan getDailyPlanById(String idDailyPlan);
    DailyPlan attachMealPlan(String idDailyPlan, String idMealPlan);
    DailyPlan detachMealPlan(String idDailyPlan, String idMealPlan);

}
