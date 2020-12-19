package com.trainer.api.repo;

import com.trainer.api.model.plan.DailyPlan;

import java.util.Collection;

public interface DailyPlanRepo {
    DailyPlan addDailyPlan(String idMentee, DailyPlan dailyPlan, int numberOfWeek);
    DailyPlan getDailyPlan(String idMentee, int numberOfWeek, int numberOfDay);
    Collection<DailyPlan> getDailyPlans(String idMentee, int numberOfWeek);
}
