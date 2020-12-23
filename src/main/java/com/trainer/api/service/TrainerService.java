package com.trainer.api.service;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.ProfileRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService{
    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private Mapper mapper;

    public List<MenteeDTO> getTrainerMentees(String id){
        return trainerRepo
                .getTrainerMentees(id)
                .stream()
                .map(mentee -> mapper
                        .getMenteeMapper()
                        .map(mentee,MenteeDTO.class))
                .collect(Collectors.toList());
    }

    public Trainer addTrainer(Trainer trainer){
        return trainerRepo.saveTrainer(trainer);
    }

    public Profile getProfile(String idTrainer){
        return profileRepo.getTrainerProfile(idTrainer);
    }

    public Profile setProfile(String idTrainer, Profile profile){
        return profileRepo.setTrainerProfile(idTrainer,profile);
    }

    public Collection<MenteeDTO> assignMentee(String idMentee, String idTrainer){
        Mentee mentee = menteeRepo.getMentee(idMentee);

        return trainerRepo
                .assignMentee(idTrainer, mentee)
                .getMentees()
                .stream()
                .map(m -> mapper
                        .getMenteeMapper()
                        .map(m,MenteeDTO.class))
                .collect(Collectors.toList());
    }

    public Collection<TrainerDTO> getAllTrainers(){
        return trainerRepo
                .getAllTrainers()
                .stream()
                .map(trainer -> mapper
                        .getTrainerMapper()
                        .map(trainer,TrainerDTO.class))
                .collect(Collectors.toList());
    }

    public MenteeDTO getTrainerMenteeById(String idTrainer, String idMentee) {
        return mapper
                .getMenteeMapper()
                .map(trainerRepo.getTrainerMenteeById(idTrainer,idMentee),MenteeDTO.class);
    }
}
