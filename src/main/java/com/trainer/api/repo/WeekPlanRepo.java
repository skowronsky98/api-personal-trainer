package com.trainer.api.repo;

import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.WeekPlan;

import java.util.Collection;

public interface WeekPlanRepo {
    Collection<WeekPlan> getWeekPlans();
    WeekPlan getWeekPlanById(String idWeekPlan);
    WeekPlan createWeekPlan(String idTrainer, String idMentee, WeekPlan weekPlan);
//    WeekPlan getWeekPlan(String idMentee, int numberOfWeek);
    void deleteWeekPlan(String idWeekPlan);
    WeekPlan attachDailyPlan(String idWeekPlan, String idDailyPlan);
    WeekPlan detachDailyPlan(String idWeekPlan, String idDailyPlan);

}
