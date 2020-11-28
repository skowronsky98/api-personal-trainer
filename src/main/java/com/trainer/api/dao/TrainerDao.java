package com.trainer.api.dao;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.model.Profile;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public Trainer getTrainnerById(String id){
        return trainerRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id trainner: "+id));
    }

    public Mentee getTrainerMenteeById(String trainnerID, String menteeID){
        return getTrainerMentees(trainnerID)
                .stream()
                .filter(mentee -> mentee.get_id().equals(menteeID))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("mentee not found: "+menteeID));
    }

    public List<Mentee> getTrainerMentees(String id){
        return getTrainnerById(id).getMentees() == null ? new ArrayList<>() : getTrainnerById(id).getMentees();
    }

    public Profile getProfile(String id){
        return getTrainnerById(id).getProfile();
    }

    public Trainer assignMentee(String idTrainer, Mentee mentee){
        return trainerRepo.findById(idTrainer).map(trainer -> {
            trainer.setMentees(trainer.addMentee(mentee));
            return trainerRepo.save(trainer);
        }).orElseThrow(() -> new ResourceNotFoundException("add metee to list"));
    }
}
