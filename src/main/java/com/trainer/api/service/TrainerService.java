package com.trainer.api.service;

import com.trainer.api.dao.MenteeDao;
import com.trainer.api.dao.TrainerDao;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Mentee;
import com.trainer.api.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerDao trainerDao;

    @Autowired
    private MenteeDao menteeDao;

    @Autowired
    private Mapper mapper;


    public Collection<Trainer> getAllTrainers(){
        return trainerDao.getAllTrainers();
    }

    public List<Mentee> getAllTrainerMentee(String id){
        return trainerDao.getTrainerMentees(id);
    }

    public Trainer addTrainer(Trainer trainer){
        return trainerDao.addTrainer(trainer);
    }

    public Trainer assignMentee(String idMentee, String idTrainer){
        Mentee mentee = menteeDao.getMenteeByID(idMentee).get();
        Trainer trainer = trainerDao.getTrainnerById(idTrainer).get();
        List<Mentee> mentees = trainer.getMentees();
        if(mentees == null)
            mentees = new ArrayList<>();

        mentees.add(mentee);
        trainer.setMentees(mentees);

        return trainerDao.addTrainer(trainer);
    }


    public Collection<TrainerDTO> getAllTrainersDTO(){
        Collection<Trainer> trainers = trainerDao.getAllTrainers();
        Collection<TrainerDTO> trainersDTO = new ArrayList<>();

        trainers.forEach(trainer -> {
            trainersDTO.add(mapper.getTrainerMapper().map(trainer,TrainerDTO.class));
        });

        return trainersDTO;
    }

}
