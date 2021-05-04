package com.trainer.api.repo;

import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;

import java.util.Collection;

public interface MenteeRepo {
    Mentee getMenteeByEmail(String email);
    Mentee getMenteeByID(String idMentee);
    Collection<Mentee> getAllMentee();
    Mentee saveMentee(Mentee mentee);
    Profile getProfile(String idMentee);
    Profile setProfile(String idMentee, Profile profile);
    Mentee assignTrainer(String idMentee, String idTrainer);
    Collection<Trainer> getTraieners(String idMentee);
    Mentee detachTrainer(String idMentee, String idTrainer);
    Dimensions getDimensions(String idMentee);
    Dimensions setDimensions(String idMentee, Dimensions dimensions);

}
