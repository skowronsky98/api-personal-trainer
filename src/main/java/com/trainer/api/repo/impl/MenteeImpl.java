package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MenteeManager;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MenteeImpl implements MenteeRepo {
    @Autowired
    private MenteeManager menteeManager;

    @Override
    public Collection<Mentee> getAllMentee(){
        return menteeManager.findAll();
    }

    @Override
    public Mentee saveMentee(Mentee mentee){
        return menteeManager.save(mentee);
    }

    @Override
    public Mentee getMentee(String idMentee){
        return menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));
    }

    @Override
    public Mentee assignTrainer(Mentee mentee, Trainer trainer) {
        mentee.setAssignedTainers(mentee.addTrainer(trainer));
        return menteeManager.save(mentee);


//        return trainerManager.findById(idTrainer).map(trainer -> {
//            trainer.setMentees(trainer.addMentee(mentee));
//            return trainerManager.save(trainer);
//        }).orElseThrow(() -> new ResourceNotFoundException("add metee to list"));
    }

    @Override
    public Collection<Trainer> getTraieners(String idMentee) {
        return getMentee(idMentee).getAssignedTainers();
    }


    @Override
    public Mentee getMenteeByID(String idMentee){
        return menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));
    }


}
