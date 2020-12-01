package com.trainer.api.service;


import com.trainer.api.repo.MenteeImpl;
import com.trainer.api.repo.TrainerImpl;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MenteeService {
    @Autowired
    private MenteeImpl menteeImpl;

    @Autowired
    private TrainerImpl trainerImpl;

    @Autowired
    private Mapper mapper;

    public Collection<Mentee> getAllMentee(){
        return menteeImpl.getAllMentee();
    }

    public Mentee addMentee(Mentee mentee){
        return menteeImpl.addMentee(mentee);
    }

    public Mentee assignTrainer(String idMentee, String idTrainer){
        Mentee mentee = menteeImpl.getMenteeByID(idMentee).get();
        Trainer trainer = trainerImpl.getTrainnerById(idTrainer);
        List<Trainer> trainers = mentee.getTrainers();
        if(trainers == null)
            trainers = new ArrayList<>();


        trainers.add(trainer);

        mentee.setTrainers(trainers);

        return menteeImpl.addMentee(mentee);
    }

    //com
    public Collection<MenteeDTO> getAllMenteeDTO() {
        Collection<Mentee> mentees = menteeImpl.getAllMentee();
        Collection<MenteeDTO> menteesDTO = new ArrayList<>();

        mentees.forEach(mentee -> {
            menteesDTO.add(mapper.getMenteeMapper().map(mentee,MenteeDTO.class));
        });

        return menteesDTO;
    }
}
