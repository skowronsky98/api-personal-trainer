package com.trainer.api.repo;

import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;

import java.util.Collection;
import java.util.List;

public interface MenteeRepo {
    Mentee getMenteeByID(String idMentee);
    Collection<Mentee> getAllMentee();
    Mentee addMentee(Mentee mentee);
    Mentee getMentee(String idMentee);
}
