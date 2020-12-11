package com.trainer.api.repo;

import com.trainer.api.model.plan.WeekPlan;

import java.util.Collection;

public interface WeekPlanRepo {
    Collection<WeekPlan> getWeelPlans(String idMentee);
    Collection<WeekPlan> addWeekPlan(String idMentee, WeekPlan weekPlan);

}
