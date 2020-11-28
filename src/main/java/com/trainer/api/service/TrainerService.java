package com.trainer.api.service;

import com.trainer.api.dao.MenteeDao;
import com.trainer.api.dao.TrainerDao;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    @Autowired
    private TrainerDao trainerDao;

    @Autowired
    private MenteeDao menteeDao;

    @Autowired
    private Mapper mapper;


//    public Collection<Trainer> getAllTrainers(){
//        return trainerDao.getAllTrainers();
//    }

    public List<MenteeDTO> getTrainerMentees(String id){
        return trainerDao
                .getTrainerMentees(id)
                .stream()
                .map(mentee -> mapper
                        .getMenteeMapper()
                        .map(mentee,MenteeDTO.class))
                .collect(Collectors.toList());
    }

    public Trainer addTrainer(Trainer trainer){
        return trainerDao.addTrainer(trainer);
    }

    public TrainerDTO assignMentee(String idMentee, String idTrainer){
        return mapper
                .getTrainerMapper()
                .map(trainerDao.assignMentee(idTrainer,menteeDao.getMentee(idMentee)),TrainerDTO.class);
    }


    public Collection<TrainerDTO> getAllTrainers(){
        return trainerDao.getAllTrainers()
                .stream()
                .map(trainer -> mapper
                        .getTrainerMapper()
                        .map(trainer,TrainerDTO.class))
                .collect(Collectors.toList());
    }

    public MenteeDTO getTrainerMenteeById(String idTrainer, String idMentee) {
        return mapper
                .getMenteeMapper()
                .map(trainerDao.getTrainerMenteeById(idTrainer,idMentee),MenteeDTO.class);
    }
}
