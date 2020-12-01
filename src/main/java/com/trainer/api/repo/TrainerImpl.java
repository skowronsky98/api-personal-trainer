package com.trainer.api.repo;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainerImpl implements TrainerRepo {
    @Autowired
    private TrainerManager trainerManager;


    @Override
    public Trainer addTrainer(Trainer trainer){
        return trainerManager.save(trainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerManager.findAll();
    }

    @Override
    public Trainer getTrainerById(String id){
        return trainerManager
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id trainner: "+id));
    }

    @Override
    public Mentee getTrainerMenteeById(String trainnerID, String menteeID){
        return getTrainerMentees(trainnerID)
                .stream()
                .filter(mentee -> mentee.get_id().equals(menteeID))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("mentee not found: "+menteeID));
    }

    @Override
    public List<Mentee> getTrainerMentees(String id){
        return getTrainerById(id).getMentees() == null ? new ArrayList<>() : getTrainerById(id).getMentees();
    }

    @Override
    public Profile getProfile(String idTrainer){
        return getTrainerById(idTrainer).getProfile();
    }

    @Override
    public Trainer assignMentee(String idTrainer, Mentee mentee){
        return trainerManager.findById(idTrainer).map(trainer -> {
            trainer.setMentees(trainer.addMentee(mentee));
            return trainerManager.save(trainer);
        }).orElseThrow(() -> new ResourceNotFoundException("add metee to list"));
    }
    
}
