package com.trainer.api.repo;

import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;

import java.util.List;

public interface TrainerRepo {
    Trainer saveTrainer(Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(String id);
    List<Mentee> getTrainerMentees(String id);
    Mentee getTrainerMenteeById(String trainnerID, String menteeID);
    Trainer assignMentee(Trainer trainer, Mentee mentee);
//    List<Trainer> getActiveAdvertisments();
    Trainer deleteInvitation(Trainer trainer, Mentee mentee);
}
