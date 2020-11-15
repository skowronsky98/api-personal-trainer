package com.trainer.api.service;


import com.trainer.api.dao.MenteeDao;
import com.trainer.api.dao.TrainerDao;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.Mentee;
import com.trainer.api.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MenteeService {
    @Autowired
    private MenteeDao menteeDao;

    @Autowired
    private TrainerDao trainerDao;

    @Autowired
    private Mapper mapper;

    public Collection<Mentee> getAllMentee(){
        return menteeDao.getAllMentee();
    }

    public Mentee addMentee(Mentee mentee){
        return menteeDao.addMentee(mentee);
    }

    public Mentee assignTrainer(String idMentee, String idTrainer){
        Mentee mentee = menteeDao.getMenteeByID(idMentee).get();
        Trainer trainer = trainerDao.getTrainnerById(idTrainer).get();
        List<Trainer> trainers = mentee.getTrainers();
        if(trainers == null)
            trainers = new ArrayList<>();


        trainers.add(trainer);

        mentee.setTrainers(trainers);

        return menteeDao.addMentee(mentee);
    }

    //com
    public Collection<MenteeDTO> getAllMenteeDTO() {
        Collection<Mentee> mentees = menteeDao.getAllMentee();
        Collection<MenteeDTO> menteesDTO = new ArrayList<>();

        mentees.forEach(mentee -> {
            menteesDTO.add(mapper.getMenteeMapper().map(mentee,MenteeDTO.class));
        });

        return menteesDTO;
    }
}
