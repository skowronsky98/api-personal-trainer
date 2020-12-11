package com.trainer.api.controller;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Profile;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.service.PlanService;
import com.trainer.api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private PlanService planService;

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

//    @GetMapping("/weekplan")
//    public WeekPlan getWeekPlan(  @RequestHeader(value = "mid")  String idMentee
//            ,@RequestHeader(value = "tid") String idTrainer
//            ,@RequestHeader(value = "numOfWeek") int numberOfWeek){
//        return planService.ge(idTrainer,idMentee,numberOfWeek);
//    }

    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer){
        return trainerService.addTrainer(trainer);
    }

    @PatchMapping
    public Collection<MenteeDTO> assignMentee(@RequestHeader(value = "mid")  String idMentee,
                               @RequestHeader(value = "tid") String idTrainer){
        return trainerService.assignMentee(idMentee,idTrainer);
    }

    @PostMapping("/weekplan")
    public Collection<WeekPlan> addWeekPlan(@RequestHeader(value = "mid") String idMentee,
                                            @RequestBody WeekPlan weekPlan){
        return planService.addWeekPlan(idMentee,weekPlan);
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
}
