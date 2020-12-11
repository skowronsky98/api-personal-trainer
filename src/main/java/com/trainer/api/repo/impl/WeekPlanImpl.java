package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MenteeManager;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.repo.WeekPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class WeekPlanImpl implements WeekPlanRepo {

    @Autowired
    private MenteeManager menteeManager;

    @Override
    public Collection<WeekPlan> getWeelPlans(String idMentee) {
        return menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee))
                .getWeekPlans();
    }

    @Override
    public Collection<WeekPlan> addWeekPlan(String idMentee,WeekPlan weekPlan) {
        Mentee mentee = menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));

        Collection<WeekPlan> weekPlans = mentee.getWeekPlans();
        if(weekPlans == null)
            weekPlans = new ArrayList<>();
        weekPlans.add(weekPlan);
        mentee.setWeekPlans(weekPlans);
        menteeManager.save(mentee);
        return mentee.getWeekPlans();
    }
}
