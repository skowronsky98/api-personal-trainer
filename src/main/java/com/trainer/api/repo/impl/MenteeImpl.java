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
    public Mentee addMentee(Mentee mentee){
        return menteeManager.save(mentee);
    }

    @Override
    public Mentee getMentee(String idMentee){
        return menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));
    }

    @Override
    public Mentee getMenteeByID(String idMentee){
        return menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));
    }

    @Override
    public Mentee assignTrainer(String idMentee, Trainer trainer) {
        return menteeManager
                .findById(idMentee)
                .map(mentee -> {
                    mentee.setTrainers(mentee.addTrainer(trainer));
                    return menteeManager.save(mentee);
                }).orElseThrow(() -> new ResourceNotFoundException("add trainer to list"));
    }
}
