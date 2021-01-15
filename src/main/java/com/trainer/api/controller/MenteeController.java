package com.trainer.api.controller;

import com.trainer.api.dto.AdvertismentDTO;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Invite;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.service.MenteeService;
import com.trainer.api.service.PlanService;
import com.trainer.api.service.SubscribeService;
import com.trainer.api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/mentee")
public class MenteeController {
    @Autowired
    private MenteeService menteeService;

    @Autowired
    private PlanService planService;

    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public Collection<MenteeDTO> getAllMentee(){
        return menteeService.getAllMenteeDTO();
    }

    @PostMapping
    public MenteeDTO addMentee(@RequestBody Mentee mentee){
        return menteeService.addMentee(mentee);
    }

    @PostMapping("/invite")
    public Collection<Invite> subscribe(@RequestHeader(value = "mid")  String idMentee,
                                        @RequestHeader(value = "tid") String idTrainer){
        return subscribeService.subscribe(idMentee,idTrainer);
    }

    @GetMapping("/advertisments")
    public List<AdvertismentDTO> getAdvertisments(){
        return trainerService.getActiveAdvertisments();
    }

    @GetMapping("/trainers")
    public Collection<TrainerDTO> getTrainers(@RequestParam(value = "id") String idMentee){
        return menteeService.getTrainers(idMentee);
    }

    @GetMapping("/profile")
    public Profile getProfile(@RequestHeader(value = "id")  String idMentee){
        return menteeService.getProfile(idMentee);
    }

    @PostMapping("/profile")
    public Profile setProfile(@RequestHeader(value = "id")  String idMentee,
                              @RequestBody Profile profile){
        return menteeService.setProfile(idMentee,profile);
    }
}
