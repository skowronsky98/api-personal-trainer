package com.trainer.api.repo;

import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;

import java.util.Collection;

public interface MenteeRepo {
    Mentee getMenteeByEmail(String email);
    Mentee getMenteeByID(String idMentee);
    Collection<Mentee> getAllMentee();
    Mentee saveMentee(Mentee mentee);
    Mentee getMentee(String idMentee);
    Mentee assignTrainer(Mentee mentee, Trainer trainer);
    Collection<Trainer> getTraieners(String idMentee);
}
