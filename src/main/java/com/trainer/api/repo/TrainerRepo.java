package com.trainer.api.repo;

import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;

import java.util.List;

public interface TrainerRepo {
    Trainer addTrainer(Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(String id);
    List<Mentee> getTrainerMentees(String id);
    Mentee getTrainerMenteeById(String trainnerID, String menteeID);
    Trainer assignMentee(String idTrainer, Mentee mentee);
    Profile getProfile(String idTrainer);

}
