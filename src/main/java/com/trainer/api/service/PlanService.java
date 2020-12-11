package com.trainer.api.service;

import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import com.trainer.api.repo.WeekPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlanService {
    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private WeekPlanRepo weekPlanRepo;

    public Collection<WeekPlan> getWeekPlans(String idMentee){
        return weekPlanRepo.getWeelPlans(idMentee);
    }

    public Collection<WeekPlan> addWeekPlan(String idMentee, WeekPlan weekPlan){
      return weekPlanRepo.addWeekPlan(idMentee,weekPlan);
    }

}
