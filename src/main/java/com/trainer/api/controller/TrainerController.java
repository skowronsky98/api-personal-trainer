package com.trainer.api.controller;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Invite;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.service.PlanService;
import com.trainer.api.service.SubscribeService;
import com.trainer.api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.metal.MetalLabelUI;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private PlanService planService;

    @Autowired
    private SubscribeService subscribeService;

    @GetMapping
    public Collection<TrainerDTO> getTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/mentees")
    public Collection<MenteeDTO> getTrainerMentees(@RequestHeader(value = "id") String idTrainer){
        return trainerService.getTrainerMentees(idTrainer);
    }

    @GetMapping("/mentee")
    public MenteeDTO getTrainerMenteeById(
            @RequestHeader(value = "mid")  String idMentee
            ,@RequestHeader(value = "tid") String idTrainer){
        return trainerService.getTrainerMenteeById(idTrainer,idMentee);
    }

    @GetMapping("/invites")
    public List<Invite> getInvites(@RequestHeader(value = "id") String idTrainer){
        return subscribeService.getInvites(idTrainer);
    }

    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer){
        return trainerService.addTrainer(trainer);
    }

    @PatchMapping
    public Collection<MenteeDTO> assignMentee(@RequestHeader(value = "mid")  String idMentee,
                               @RequestHeader(value = "tid") String idTrainer){
        return trainerService.assignMentee(idMentee,idTrainer);
    }

    @GetMapping("/profile")
    public Profile getProfile( @RequestHeader(value = "id") String idTrainer){
        return trainerService.getProfile(idTrainer);
    }

    @PostMapping("/profile")
    public Profile setProfile( @RequestHeader(value = "id") String idTrainer,
                               @RequestBody Profile profile){
        return trainerService.setProfile(idTrainer,profile);
    }

    @PostMapping("/meal")
    public Meal addMeal(@RequestHeader(value = "id") String idTrainer,
                         @RequestBody Meal meal){
        return trainerService.addMeal(meal, idTrainer);
    }
}
