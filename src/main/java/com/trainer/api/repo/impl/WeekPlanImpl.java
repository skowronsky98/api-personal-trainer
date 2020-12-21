package com.trainer.api.repo.impl;

import com.trainer.api.manager.WeekPlanManager;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.repo.WeekPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class WeekPlanImpl implements WeekPlanRepo {
    @Autowired
    private WeekPlanManager weekPlanManager;

    @Override
    public Collection<WeekPlan> getWeekPlans(String idMentee) {
        return null;
    }

    @Override
    public WeekPlan addWeekPlan(WeekPlan weekPlan) {
        return weekPlanManager.save(weekPlan);
    }

    @Override
    public WeekPlan getWeekPlan(String idMentee, int numberOfWeek) {
        return null;
    }

    @Override
    public void deleteWeekPlan(WeekPlan weekPlan) {
        weekPlanManager.delete(weekPlan);
    }
}