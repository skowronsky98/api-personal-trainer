package com.trainer.api.service;


import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MenteeManager;
import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MenteeService implements MenteeRepo{

    @Autowired
    private MenteeManager menteeManager;

    @Autowired
    private TrainerRepo trainerRepo;

    @Override
    public Mentee getMenteeByEmail(String email) {
        return getAllMentee()
                .stream()
                .filter(mentee -> mentee.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("mentee not exist email: "+email));
    }

    @Override
    public Mentee getMenteeByID(String idMentee) {
        return menteeManager.findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));
    }

    @Override
    public Collection<Mentee> getAllMentee() {
        return menteeManager.findAll();
    }

    @Override
    public Mentee saveMentee(Mentee mentee) {
        return menteeManager.save(mentee);
    }

    @Override
    public Profile getProfile(String idMentee) {
        return getMenteeByID(idMentee).getProfile();
    }

    @Override
    public Profile setProfile(String idMentee, Profile profile) {
        Mentee mentee = getMenteeByID(idMentee);
        mentee.setProfile(profile);
        saveMentee(mentee);
        return mentee.getProfile();
    }

    @Override
    public Dimensions getDimensions(String idMentee) {
        return getMenteeByID(idMentee).getDimensions();
    }

    @Override
    public Dimensions setDimensions(String idMentee, Dimensions dimensions) {
        Mentee mentee = getMenteeByID(idMentee);
        mentee.setDimensions(dimensions);
        saveMentee(mentee);
        return mentee.getDimensions();
    }


    @Override
    public Mentee assignTrainer(String idMentee, String idTrainer) {
        Mentee mentee = getMenteeByID(idMentee);
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);

        mentee.addTrainer(trainer);
        return saveMentee(mentee);
    }

    @Override
    public Collection<Trainer> getTraieners(String idMentee) {
        Mentee mentee = getMenteeByID(idMentee);
        return mentee.getAssignedTainers();
    }

    @Override
    public Mentee detachTrainer(String idMentee, String idTrainer) {
        Mentee mentee = getMenteeByID(idMentee);

        List<Trainer> trainers = mentee.getAssignedTainers();

        for (int i = 0; i < trainers.size(); i++) {
            if(trainers.get(i).get_id().equals(idTrainer)){
                trainers.remove(i);
                break;
            }
        }

        mentee.setAssignedTainers(trainers);
        return saveMentee(mentee);
    }
}
