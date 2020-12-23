package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.WeekPlanManager;
import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.DailyPlanRepo;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import com.trainer.api.repo.WeekPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class WeekPlanImpl implements WeekPlanRepo {
    @Autowired
    private WeekPlanManager weekPlanManager;

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private DailyPlanRepo dailyPlanRepo;

    @Override
    public Collection<WeekPlan> getWeekPlans() {
        return weekPlanManager.findAll();
    }

    @Override
    public WeekPlan getWeekPlanById(String idWeekPlan) {
        return weekPlanManager
                .findById(idWeekPlan)
                .orElseThrow(() -> new ResourceNotFoundException("id weekPlan: "+idWeekPlan));
    }

    @Override
    public WeekPlan createWeekPlan(String idTrainer, String idMentee, WeekPlan weekPlan){
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        Mentee mentee = trainer
                .getMentees()
                .stream()
                .filter(m -> m.get_id().equals(idMentee))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));

        weekPlan.setTrainer(trainer);

        WeekPlan wp = weekPlanManager.save(weekPlan);

        trainer.addWeekPlan(wp);
        trainerRepo.saveTrainer(trainer);
        mentee.addWeekPlan(wp);
        menteeRepo.saveMentee(mentee);

        return wp;
    }

    @Override
    public void deleteWeekPlan(String idWeekPlan) {
        WeekPlan weekPlan = getWeekPlanById(idWeekPlan);
        weekPlanManager.delete(weekPlan);
    }

    @Override
    public WeekPlan attachDailyPlan(String idWeekPlan, String idDailyPlan) {
        WeekPlan weekPlan = getWeekPlanById(idWeekPlan);
        DailyPlan dailyPlan = dailyPlanRepo.getDailyPlanById(idDailyPlan);
        weekPlan.addDailyPlan(dailyPlan);
        return weekPlanManager.save(weekPlan);
    }

    @Override
    public WeekPlan detachDailyPlan(String idWeekPlan, String idDailyPlan) {
        WeekPlan weekPlan = getWeekPlanById(idWeekPlan);
        DailyPlan dailyPlan = weekPlan.getDailyPlans()
                .stream()
                .filter(dP -> dP.get_id().equals(idDailyPlan))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("DailyPlan is not attached to WeekPlan idDailyPlan: "+idDailyPlan));

        weekPlan.getDailyPlans().remove(dailyPlan);

        return weekPlanManager.save(weekPlan);
    }
}