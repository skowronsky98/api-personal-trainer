package com.trainer.api.repo;

import com.trainer.api.model.plan.WeekPlan;

import java.util.Collection;

public interface WeekPlanRepo {
    Collection<WeekPlan> getWeekPlans(String idMentee);
    WeekPlan addWeekPlan(WeekPlan weekPlan);
    WeekPlan getWeekPlan(String idMentee, int numberOfWeek);
    void deleteWeekPlan(WeekPlan weekPlan);
}
