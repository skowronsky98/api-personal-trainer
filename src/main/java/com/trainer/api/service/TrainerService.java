package com.trainer.api.service;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.TrainerManager;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService implements TrainerRepo{

    @Autowired
    private TrainerManager trainerManager;

    @Autowired
    private MenteeRepo menteeRepo;

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerManager.save(trainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerManager.findAll();
    }

    @Override
    public Trainer getTrainerById(String id) {
        return trainerManager.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id trainer not exist: "+ id));
    }

    @Override
    public List<Mentee> getTrainerMentees(String id) {
        return getTrainerById(id).getMentees();
    }

    @Override
    public Mentee getTrainerMenteeById(String trainnerID, String menteeID) {
        return getTrainerMentees(trainnerID).stream()
                .filter(mentee -> mentee.get_id().equals(menteeID))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("trainer is not attached to this mentee: "+ menteeID));
    }

    @Override
    public Trainer assignMentee(String idTrainer, String idMentee) {
        Trainer trainer = getTrainerById(idTrainer);
        Mentee mentee = menteeRepo.getMenteeByID(idMentee);

        List<Mentee> mentees = trainer.getMentees();
        mentees.add(mentee);
        trainer.setMentees(mentees);

        return saveTrainer(trainer);
    }

    @Override
    public Trainer detachMentee(String idTrainer, String idMentee) {
        Trainer trainer = getTrainerById(idTrainer);

        List<Mentee> mentees = trainer.getMentees();


        for (int i = 0; i < mentees.size(); i++) {
            if(mentees.get(i).get_id().equals(idMentee)){
                mentees.remove(i);
                break;
            }
        }

        trainer.setMentees(mentees);

        return saveTrainer(trainer);
    }


    @Override
    public Profile getProfile(String idTrainer) {
        return getTrainerById(idTrainer).getProfile();
    }

    @Override
    public Profile setProfile(String idTrainer, Profile profile) {
        Trainer trainer = getTrainerById(idTrainer);
        trainer.setProfile(profile);
        return saveTrainer(trainer).getProfile();
    }

    @Override
    public Dimensions getDiemensions(String idTrainer) {
        return getTrainerById(idTrainer).getDimensions();
    }

    @Override
    public Dimensions setDimensions(String idTrainer, Dimensions dimensions) {
        Trainer trainer = getTrainerById(idTrainer);
        trainer.setDimensions(dimensions);
        return saveTrainer(trainer).getDimensions();
    }

    @Override
    public Meal addMeal(String idTrainer, Meal meal) {
        Trainer trainer = getTrainerById(idTrainer);
        List<Meal> meals = trainer.getMeals();

        meals.add(meal);
        trainer.setMeals(meals);
        saveTrainer(trainer);
        return meal;
    }

    @Override
    public Meal getMeal(String idTrainer, Long idMeal) {
        return getTrainerById(idTrainer).getMeals()
                .stream()
                .filter(meal -> meal.getIdMeal().equals(idMeal))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("meal doesnt exist: "+ idMeal));
    }

    @Override
    public List<Meal> getMeals(String idTrainer) {
        return getTrainerById(idTrainer).getMeals();
    }

    @Override
    public Meal deleteMeal(String idTrainer, Long idMeal) {
        Trainer trainer = getTrainerById(idTrainer);
        Meal meal = getMeal(idTrainer,idMeal);

        List<Meal> meals = trainer.getMeals();
        meals.remove(meal);
        trainer.setMeals(meals);
        saveTrainer(trainer);

        return meal;
    }

}
