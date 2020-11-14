package com.trainer.api.controller;

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
    public Collection<Trainer> getTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/mentees")
    public Collection<Mentee> getTrainerMentee(@RequestHeader(value = "tid") String idTrainer){

        return trainerService.getAllTrainerMentee(idTrainer);
    }

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
