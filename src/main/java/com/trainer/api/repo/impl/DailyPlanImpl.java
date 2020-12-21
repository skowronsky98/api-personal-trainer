package com.trainer.api.repo.impl;

import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.repo.DailyPlanRepo;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DailyPlanImpl implements DailyPlanRepo {

    @Override
    public DailyPlan addDailyPlan(String idMentee, DailyPlan dailyPlan, int numberOfWeek) {
        return null;
    }

    @Override
    public DailyPlan getDailyPlan(String idMentee, int numberOfWeek, int numberOfDay) {
        return null;
    }

    @Override
    public Collection<DailyPlan> getDailyPlans(String idMentee, int numberOfWeek) {
        return null;
    }
}
