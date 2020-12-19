package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MenteeManager;
import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.repo.DailyPlanRepo;
import com.trainer.api.repo.WeekPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
