package com.trainer.api.repo;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;

import java.util.List;

public interface TrainerRepo {
    Trainer saveTrainer(Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(String id);
    List<Mentee> getTrainerMentees(String id);
    Mentee getTrainerMenteeById(String trainnerID, String menteeID);
    Trainer assignMentee(String idTrainer, String idMentee);
    Trainer detachMentee(String idTrainer, String idMentee);
//    List<Trainer> getActiveAdvertisments();

    Profile getProfile(String idTrainer);
    Profile setProfile(String idTrainer, Profile profile);
    Dimensions getDiemensions(String idTrainer);
    Dimensions setDimensions(String idTrainer, Dimensions dimensions);

    Meal addMeal(String idTrainer, Meal meal);
    Meal getMeal(String idTrainer, Long idMeal);
    List<Meal> getMeals(String idTrainer);
    Meal deleteMeal(String idTrainer, Long idMeal);
}
