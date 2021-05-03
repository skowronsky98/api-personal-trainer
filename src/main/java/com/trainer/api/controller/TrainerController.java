package com.trainer.api.controller;

import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.TrainerRepo;
import com.trainer.api.service.SubscribeService;
import com.trainer.api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

//import com.trainer.api.model.Invite;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private SubscribeService subscribeService;

    @GetMapping("/all")
    public Collection<TrainerDTO> getTrainers(){
        return trainerRepo.getAllTrainers().stream()
                .map(trainer -> mapper.getTrainerMapper().map(trainer,TrainerDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping
    public TrainerDTO getTrainer(@RequestParam(value = "id") String idTrainer){
        return mapper.getTrainerMapper()
                .map(trainerRepo.getTrainerById(idTrainer),TrainerDTO.class);
    }

    @PostMapping
    public TrainerDTO addTrainer(@RequestBody Trainer trainer){
        return mapper.getTrainerMapper()
                .map( trainerRepo.saveTrainer(trainer),TrainerDTO.class);
    }

//    @GetMapping("/mentees")
//    public Collection<MenteeDTO> getTrainerMentees(@RequestParam(value = "id") String idTrainer){
//        return trainerService.getTrainerMentees(idTrainer);
//    }
//
//
////    @GetMapping("/advertisments")
////    public List<AdvertismentDTO> getAdvertisments(){
////        return trainerService.getActiveAdvertisments();
////    }
//
//    @GetMapping("/mentee")
//    public MenteeDTO getTrainerMenteeById(
//            @RequestParam(value = "mid")  String idMentee
//            ,@RequestParam(value = "tid") String idTrainer){
//        return trainerService.getTrainerMenteeById(idTrainer,idMentee);
//    }
//
//    @GetMapping("/invites")
//    public List<Invite> getInvites(@RequestParam(value = "id") String idTrainer){
//        return subscribeService.getInvites(idTrainer);
//    }
//
//
//
//    @PatchMapping
//    public MenteeDTO assignMentee(@RequestParam(value = "mid")  String idMentee,
//                               @RequestParam(value = "tid") String idTrainer){
//        return trainerService.assignMentee(idMentee,idTrainer);
//    }
//
//    @GetMapping("/profile")
//    public Profile getProfile( @RequestParam(value = "id") String idTrainer){
//        return trainerService.getProfile(idTrainer);
//    }
//
//    @PostMapping("/profile")
//    public Profile setProfile( @RequestParam(value = "id") String idTrainer,
//                               @RequestBody Profile profile){
//        return trainerService.setProfile(idTrainer,profile);
//    }
//
//    @PostMapping("/meal")
//    public Meal addMeal(@RequestParam(value = "id") String idTrainer,
//                         @RequestBody Meal meal){
//        return trainerService.addMeal(meal, idTrainer);
//    }

}
