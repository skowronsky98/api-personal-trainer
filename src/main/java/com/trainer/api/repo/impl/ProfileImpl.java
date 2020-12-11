package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MenteeManager;
import com.trainer.api.manager.TrainerManager;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileImpl implements ProfileRepo {
    @Autowired
    private MenteeManager menteeManager;

    @Autowired
    private TrainerManager trainerManager;

    @Override
    public Profile getMenteeProfile(String idMentee) {
        return menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee))
                .getProfile();
    }

    @Override
    public Profile getTrainerProfile(String idTrainer) {
        return trainerManager
                .findById(idTrainer)
                .orElseThrow(() -> new ResourceNotFoundException("id trainer: "+ idTrainer))
                .getProfile();
    }

    @Override
    public Profile setMenteeProfile(String idMentee, Profile profile) {
        Mentee mentee = menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));

        mentee.setProfile(profile);
        menteeManager.save(mentee);
        return mentee.getProfile();
    }

    @Override
    public Profile setTrainerProfile(String idTrainner, Profile profile) {
        Trainer trainer = trainerManager
                .findById(idTrainner)
                .orElseThrow(() -> new ResourceNotFoundException("id trainer: "+idTrainner));

        trainer.setProfile(profile);
        trainerManager.save(trainer);
        return trainer.getProfile();
    }
}
