package com.trainer.api.service;


import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MenteeService {
    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private Mapper mapper;

    public Collection<Mentee> getAllMentee(){
        return menteeRepo.getAllMentee();
    }

    public Mentee addMentee(Mentee mentee){
        return menteeRepo.addMentee(mentee);
    }

    public Mentee assignTrainer(String idMentee, String idTrainer){
        Mentee mentee = menteeRepo.getMenteeByID(idMentee);
        Trainer trainer = trainerRepo.getTrainerById(idTrainer);
        List<Trainer> trainers = mentee.getTrainers();
        if(trainers == null)
            trainers = new ArrayList<>();


        trainers.add(trainer);

        mentee.setTrainers(trainers);

        return menteeRepo.addMentee(mentee);
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
