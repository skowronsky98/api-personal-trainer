package com.trainer.api.service;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.MenteeImpl;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService{
    //dobrze
    @Autowired
    private TrainerRepo trainerRepo;

    //zle
    @Autowired
    private MenteeImpl menteeImpl;

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
        return trainerRepo.addTrainer(trainer);
    }

    public TrainerDTO assignMentee(String idMentee, String idTrainer){
        return mapper
                .getTrainerMapper()
                .map(trainerRepo.assignMentee(idTrainer, menteeImpl.getMentee(idMentee)),TrainerDTO.class);
    }

    public Collection<TrainerDTO> getAllTrainers(){
        return trainerRepo.getAllTrainers()
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
