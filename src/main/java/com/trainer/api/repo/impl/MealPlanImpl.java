package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MealPlanManager;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MealPlanRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealPlanImpl implements MealPlanRepo {

    @Autowired
    private MealPlanManager mealPlanManager;

    @Autowired
    private TrainerRepo trainerRepo;

    @Override
    public void deleteMealPlan(MealPlan mealPlan) {
        mealPlanManager.delete(mealPlan);
    }

    @Override
    public MealPlan getMealPlanById(String idMealPlan) {
        return mealPlanManager
                .findById(idMealPlan)
                .orElseThrow(() -> new ResourceNotFoundException("id mealPlan: "+idMealPlan));
    }

    @Override
    public void deleteMealPlanById(String idMealPlan) {
        mealPlanManager.deleteById(idMealPlan);
    }

    @Override
    public MealPlan createMealPlan(MealPlan mealPlan, String idTrainer) {
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        MealPlan mP = mealPlanManager.save(mealPlan);

        trainer.addMealPlan(mP);
        trainerRepo.saveTrainer(trainer);
        return mP;
    }
}
