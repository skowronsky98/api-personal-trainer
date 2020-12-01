package com.trainer.api.service;

import com.trainer.api.repo.MenteeImpl;
import com.trainer.api.repo.TrainerImpl;
import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.model.plan.WeekPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    @Autowired
    private TrainerImpl trainerImpl;

    @Autowired
    private MenteeImpl menteeImpl;

    public WeekPlan getWeekPlan(String idTrainer, String idMentee, int numberOfWeek){
        return trainerImpl
                .getTrainerMenteeById(idTrainer,idMentee)
                .getWeekPlans()
                .stream()
                .filter(numOfWeek -> numOfWeek.equals(numberOfWeek))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Not found traner: " + idTrainer + " mentee: "+idMentee+" numOfWeek: "+numberOfWeek));
    }

//    public WeekPlan addWeekPlan(String idTrainer, String idMentee, int numberOfWeek){
//        WeekPlan weekPlan = trainerDao
//                .getTrainerMenteeById(idTrainer,idMentee)
//                .getWeekPlans()
//                .stream().map(weekPlan1 -> )
//
//
//    }
}
