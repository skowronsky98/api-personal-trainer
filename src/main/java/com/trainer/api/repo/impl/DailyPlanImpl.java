package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.DailPlanManager;
import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.DailyPlanRepo;
import com.trainer.api.repo.MealPlanRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DailyPlanImpl implements DailyPlanRepo {

    @Autowired
    private DailPlanManager dailPlanManager;

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private MealPlanRepo mealPlanRepo;

    @Override
    public DailyPlan createDailyPlan(DailyPlan dailyPlan, String idTrainer) {
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        DailyPlan dP = dailPlanManager.save(dailyPlan);
        trainer.addDailyPlan(dailyPlan);
        trainerRepo.saveTrainer(trainer);
        return dP;
    }

    @Override
    public void deleteDailyPlan(String idDailyPlan) {
        dailPlanManager.deleteById(idDailyPlan);
    }

    @Override
    public DailyPlan getDailyPlanById(String idDailyPlan) {
        return dailPlanManager.findById(idDailyPlan)
                .orElseThrow(() -> new ResourceNotFoundException("id trainner: "+idDailyPlan));
    }

    @Override
    public DailyPlan attachMealPlan(String idDailyPlan, String idMealPlan) {
        MealPlan mealPlan = mealPlanRepo.getMealPlanById(idMealPlan);
        DailyPlan dailyPlan = getDailyPlanById(idDailyPlan);
        dailyPlan.addMealPlan(mealPlan);
        return dailPlanManager.save(dailyPlan);
    }

    @Override
    public DailyPlan detachMealPlan(String idDailyPlan, String idMealPlan) {
        DailyPlan dailyPlan = getDailyPlanById(idDailyPlan);
        MealPlan mealPlan = dailyPlan.getMealPlans()
                .stream()
                .filter(mP -> mP.get_id().equals(idMealPlan))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("attached id mealPlan: "+idMealPlan));

        dailyPlan.getMealPlans().remove(mealPlan);
        return dailPlanManager.save(dailyPlan);
    }


}
