package com.trainer.api.dao;

import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TrainerDao {
    @Autowired
    private TrainerRepo trainerRepo;

    public List<Trainer> getAllTrainers() {
        return trainerRepo.findAll();
    }

    public Trainer addTrainer(Trainer trainer){
        return trainerRepo.save(trainer);
    }

    public Optional<Trainer> getTrainnerById(String id){
        return trainerRepo.findById(id);
    }

    public List<Mentee> getTrainerMentees(String id){
        Trainer trainer = getTrainnerById(id).get();

        return trainer.getMentees();
    }
}
