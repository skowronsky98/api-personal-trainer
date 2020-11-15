package com.trainer.api.controller;

import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Mentee;
import com.trainer.api.model.Trainer;
import com.trainer.api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public Collection<TrainerDTO> getTrainers(){
        return trainerService.getAllTrainersDTO();
    }

    @GetMapping("/mentees")
    public Collection<Mentee> getTrainerMentee(@RequestHeader(value = "tid") String idTrainer){

        return trainerService.getAllTrainerMentee(idTrainer);
    }
    //zdz

    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer){
        return trainerService.addTrainer(trainer);
    }

    @PatchMapping
    public Trainer assignMentee(@RequestHeader(value = "mid")  String idMentee,
                               @RequestHeader(value = "tid") String idTrainer){
        return trainerService.assignMentee(idMentee,idTrainer);
    }
}
