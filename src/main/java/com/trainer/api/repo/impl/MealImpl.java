package com.trainer.api.repo.impl;

import com.trainer.api.manager.TrainerManager;
import com.trainer.api.model.Meal;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MealRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MealImpl implements MealRepo {

    @Autowired
    private TrainerManager trainerManager;

    @Autowired
    private TrainerRepo trainerRepo;

    @Override
    public Meal addMeal(Meal meal, String idTrainer) {
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        trainer.addMeal(meal);
        trainerRepo.saveTrainer(trainer);
        return meal;
    }

    @Override
    public Collection<Meal> getAllMeals(String idTrainer) {
        return null;
    }

    @Override
    public void deleteMeal(Meal meal, String idTrainer) {

    }
}
