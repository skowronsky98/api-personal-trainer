package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.TrainerManager;
import com.trainer.api.model.Invite;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainerImpl implements TrainerRepo {
    @Autowired
    private TrainerManager trainerManager;


    @Override
    public Trainer saveTrainer(Trainer trainer){
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
    public Trainer assignMentee(Trainer trainer, Mentee mentee){
        trainer.setMentees(trainer.addMentee(mentee));
        return trainerManager.save(trainer);
    }

    @Override
    public List<Trainer> getActiveAdvertisments() {
        return trainerManager.findAll()
                .stream()
                .filter(trainer -> trainer.getAdvertisment().getActive())
                .collect(Collectors.toList());
    }

    @Override
    public Trainer deleteInvitation(Trainer trainer, Mentee mentee) {
        List<Invite> invites = trainer.getInvites();

        if(invites != null){
            Invite invite =  invites.stream()
                    .filter(i -> i.getMentee().get_id().equals(mentee.get_id()))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("mentee not found in invites"));
            invites.remove(invite);
            trainer.setInvites(invites);
        }else
            throw new ResourceNotFoundException("No invites");

        return trainerManager.save(trainer);
    }

}
