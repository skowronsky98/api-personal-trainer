package com.trainer.api.controller;

import com.trainer.api.dto.AdvertismentDTO;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.AdvertismentRepo;
import com.trainer.api.repo.TrainerRepo;
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
    private AdvertismentRepo advertismentRepo;

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

    @GetMapping("/mentees")
    public Collection<MenteeDTO> getTrainerMentees(@RequestParam(value = "id") String idTrainer){
        return trainerRepo.getTrainerMentees(idTrainer)
                .stream()
                .map(mentee -> mapper.getMenteeMapper().map(mentee,MenteeDTO.class))
                .collect(Collectors.toList());
    }

    @PatchMapping("/mentee/attach")
    public TrainerDTO assignMentee(@RequestParam(value = "mid")  String idMentee,
                               @RequestParam(value = "tid") String idTrainer){
        return mapper.getTrainerMapper()
                .map(trainerRepo.assignMentee(idMentee,idTrainer),TrainerDTO.class);
    }


    @PatchMapping("/mentee/detach")
    public TrainerDTO detachMentee(@RequestParam(value = "mid")  String idMentee,
                                   @RequestParam(value = "tid") String idTrainer){
        return mapper.getTrainerMapper()
                .map(trainerRepo.detachMentee(idMentee,idTrainer),TrainerDTO.class);
    }

    @GetMapping("/profile")
    public Profile getProfile(@RequestParam(value = "id") String idTrainer){
        return trainerRepo.getProfile(idTrainer);
    }

    @PostMapping("/profile")
    public Profile setProfile( @RequestParam(value = "id") String idTrainer,
                               @RequestBody Profile profile){
        return trainerRepo.setProfile(idTrainer,profile);
    }

    @GetMapping("/dimensions")
    public Dimensions getDimensions(@RequestParam(value = "id") String idTrainer){
        return trainerRepo.getDiemensions(idTrainer);
    }

    @PostMapping("/dimensions")
    public Dimensions setDimensions( @RequestParam(value = "id") String idTrainer,
                               @RequestBody Dimensions dimensions){
        return trainerRepo.setDimensions(idTrainer,dimensions);
    }


    @PostMapping("/meal")
    public Meal addMeal(@RequestParam(value = "id") String idTrainer,
                        @RequestBody Meal meal){
        return trainerRepo.addMeal(idTrainer, meal);
    }

    @GetMapping("/meal")
    public Meal getMealById(@RequestParam(value = "id") String idTrainer,
                        @RequestBody Long idMeal){
        return trainerRepo.getMeal(idTrainer, idMeal);
    }

    @GetMapping("/meals")
    public Collection<Meal> getMeals(@RequestParam(value = "id") String idTrainer){
        return trainerRepo.getMeals(idTrainer);
    }

    @DeleteMapping("/meal")
    public Meal deleteMeal(@RequestParam(value = "id") String idTrainer,
                            @RequestBody Long idMeal){
        return trainerRepo.deleteMeal(idTrainer, idMeal);
    }

    @GetMapping("/advertisment/all")
    public Collection<AdvertismentDTO> getAllAdvertisment(@RequestParam(value = "idg")Integer dietGoals){
        return advertismentRepo.getAllAdvertisment(dietGoals).stream()
                .map(add -> mapper.getAdvertismentMapper().map(add,AdvertismentDTO.class))
                .collect(Collectors.toList());
    }

    @PatchMapping("/advertisment")
    public void subsribe(@RequestParam(value = "ida") String idAd,
                         @RequestParam(value = "idt") String idTrainer){
        advertismentRepo.subscribe(idAd,idTrainer);
    }

}
