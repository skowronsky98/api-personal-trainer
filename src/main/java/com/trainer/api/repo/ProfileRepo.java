package com.trainer.api.repo;

import com.trainer.api.model.Profile;

public interface ProfileRepo {
    Profile getMenteeProfile(String idMentee);
    Profile getTrainerProfile(String idTrainer);
    Profile setMenteeProfile(String idMentee, Profile profile);
    Profile setTrainerProfile(String idTrainner, Profile profile);

}
