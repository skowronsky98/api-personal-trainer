package com.trainer.api.service;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeImpl;
import com.trainer.api.repo.TrainerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService{
    @Autowired
    private TrainerImpl trainerImpl;

    @Autowired
    private MenteeImpl menteeImpl;

    @Autowired
    private Mapper mapper;

    public List<MenteeDTO> getTrainerMentees(String id){
        return trainerImpl
                .getTrainerMentees(id)
                .stream()
                .map(mentee -> mapper
                        .getMenteeMapper()
                        .map(mentee,MenteeDTO.class))
                .collect(Collectors.toList());
    }

    public Trainer addTrainer(Trainer trainer){
        return trainerImpl.addTrainer(trainer);
    }

    public TrainerDTO assignMentee(String idMentee, String idTrainer){
        return mapper
                .getTrainerMapper()
                .map(trainerImpl.assignMentee(idTrainer, menteeImpl.getMentee(idMentee)),TrainerDTO.class);
    }


    public Collection<TrainerDTO> getAllTrainers(){
        return trainerImpl.getAllTrainers()
                .stream()
                .map(trainer -> mapper
                        .getTrainerMapper()
                        .map(trainer,TrainerDTO.class))
                .collect(Collectors.toList());
    }

    public MenteeDTO getTrainerMenteeById(String idTrainer, String idMentee) {
        return mapper
                .getMenteeMapper()
                .map(trainerImpl.getTrainerMenteeById(idTrainer,idMentee),MenteeDTO.class);
    }
}
