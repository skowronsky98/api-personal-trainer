package com.trainer.api.service;


import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Profile;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.ProfileRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenteeService {
    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private Mapper mapper;

    public Collection<Mentee> getAllMentee(){
        return menteeRepo.getAllMentee();
    }

    public MenteeDTO addMentee(Mentee mentee){
        return mapper
                .getMenteeMapper()
                .map(menteeRepo.addMentee(mentee),MenteeDTO.class);
    }

    public Profile getProfile(String idMentee){
        return profileRepo.getMenteeProfile(idMentee);
    }

    public Profile setProfile(String idMentee, Profile profile){
        return profileRepo.setMenteeProfile(idMentee,profile);
    }

    public Collection<TrainerDTO> assignTrainer(String idMentee, String idTrainer){
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        return menteeRepo
                .assignTrainer(idMentee,trainer)
                .getTrainers()
                .stream()
                .map( t -> mapper
                        .getTrainerMapper()
                        .map(t,TrainerDTO.class))
                .collect(Collectors.toList());
    }

    //com
    public Collection<MenteeDTO> getAllMenteeDTO() {
        Collection<Mentee> mentees = menteeRepo.getAllMentee();
        Collection<MenteeDTO> menteesDTO = new ArrayList<>();

        mentees.forEach(mentee -> {
            menteesDTO.add(mapper.getMenteeMapper().map(mentee,MenteeDTO.class));
        });

        return menteesDTO;
    }
}
