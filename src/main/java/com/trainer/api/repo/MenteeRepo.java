package com.trainer.api.repo;

import com.trainer.api.model.user.Mentee;

import java.util.Collection;

public interface MenteeRepo {
    Mentee getMenteeByID(String idMentee);
    Collection<Mentee> getAllMentee();
    Mentee addMentee(Mentee mentee);
    Mentee getMentee(String idMentee);
}
