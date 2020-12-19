package com.trainer.api.service;

import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import com.trainer.api.repo.WeekPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return weekPlanRepo.getWeekPlans(idMentee);
    }

    public WeekPlan addWeekPlan(String idTrainer, String idMentee, WeekPlan weekPlan){
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        Mentee mentee = trainerRepo.getTrainerMenteeById(idTrainer,idMentee);

        weekPlan.setTrainer(trainer);

        WeekPlan wp = weekPlanRepo.addWeekPlan(weekPlan);

        Collection<WeekPlan> trainerWeekPlans = trainer.getWeekPlans();
        Collection<WeekPlan> menteeWeekPlans = mentee.getWeekPlans();
        if(trainerWeekPlans == null)
            trainerWeekPlans = new ArrayList<>();

        if(menteeWeekPlans == null)
            menteeWeekPlans = new ArrayList<>();

        trainerWeekPlans.add(wp);
        trainer.setWeekPlans(trainerWeekPlans);
        trainerRepo.addTrainer(trainer);

        menteeWeekPlans.add(wp);
        mentee.setWeekPlans(menteeWeekPlans);
        menteeRepo.addMentee(mentee);

        return wp;
    }

}
