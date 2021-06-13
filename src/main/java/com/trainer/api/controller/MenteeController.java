package com.trainer.api.controller;

import com.trainer.api.dto.AdvertismentDTO;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.repo.AdvertismentRepo;
import com.trainer.api.repo.MenteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mentee")
public class MenteeController {
    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private AdvertismentRepo advertismentRepo;

    @GetMapping
    public MenteeDTO getMentee(
            @RequestParam(value = "email") String email){
        return mapper
                .getMenteeMapper()
                .map(menteeRepo.getMenteeByEmail(email),MenteeDTO.class);
    }

    @GetMapping("/all")
    public Collection<MenteeDTO> getAllMentee(){
        return menteeRepo.getAllMentee()
                .stream()
                .map(mentee -> mapper.getMenteeMapper().map(mentee,MenteeDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public MenteeDTO addMentee(@RequestBody Mentee mentee){
        return mapper
                .getMenteeMapper()
                .map(menteeRepo.saveMentee(mentee),MenteeDTO.class);
    }

    @PatchMapping("/trainer/attach")
    public TrainerDTO attachTrainer(@RequestParam(value = "tid") String idTrainer,
                                    @RequestParam(value = "mid") String idMentee){
        return mapper.getTrainerMapper()
                .map(menteeRepo.assignTrainer(idMentee,idTrainer),TrainerDTO.class);
    }

    @PatchMapping("/trainer/detach")
    public TrainerDTO detachTrainer(@RequestParam(value = "tid") String idTrainer,
                                    @RequestParam(value = "mid") String idMentee){
        return mapper.getTrainerMapper()
                .map(menteeRepo.detachTrainer(idMentee,idTrainer),TrainerDTO.class);
    }

    @GetMapping("/trainers")
    public Collection<TrainerDTO> getTrainers(@RequestParam(value = "id") String idMentee){
        return  menteeRepo.getTraieners(idMentee)
                .stream()
                .map(trainer -> mapper.getTrainerMapper().map(trainer,TrainerDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/profile")
    public Profile getProfile(@RequestParam(value = "id")  String idMentee){
        return menteeRepo.getProfile(idMentee);
    }

    @PostMapping("/profile")
    public Profile setProfile(@RequestParam(value = "id")  String idMentee,
                              @RequestBody Profile profile){
        return menteeRepo.setProfile(idMentee,profile);
    }

    @GetMapping("/dimensions")
    public Dimensions getDimensions(@RequestParam(value = "id")  String idMentee){
        return menteeRepo.getDimensions(idMentee);
    }

    @PostMapping("/dimensions")
    public Dimensions setDimensions(@RequestParam(value = "id")  String idMentee,
                              @RequestBody Dimensions dimensions){
        return menteeRepo.setDimensions(idMentee,dimensions);
    }


    @GetMapping("/advertisment")
    public AdvertismentDTO getAdvertisment(@RequestParam(value = "id")  String idMentee){
        return mapper.getAdvertismentMapper()
                .map(advertismentRepo.getAdvertisment(idMentee),AdvertismentDTO.class);


    }


    @PostMapping("/advertisment")
    public AdvertismentDTO addAdvertisment(@RequestParam(value = "id")  String idMentee, @RequestBody Advertisment advertisment){
        return mapper.getAdvertismentMapper()
                .map(advertismentRepo.addAdvertisment(advertisment,idMentee),AdvertismentDTO.class);


    }

    @DeleteMapping("/advertisment")
    public AdvertismentDTO deleteAdvertisment(@RequestParam(value = "id")  String idMentee){
        return mapper.getAdvertismentMapper()
                .map(advertismentRepo.deleteAdvertisment(idMentee),AdvertismentDTO.class);

    }


    @GetMapping("/advertisment/all")
    public Collection<AdvertismentDTO> getAllAdvertisment(@RequestParam(value = "id")  Integer dietGoals){
        return advertismentRepo.getAllAdvertisment(dietGoals).stream()
                        .map(add -> mapper.getAdvertismentMapper().map(add,AdvertismentDTO.class))
                .collect(Collectors.toList());
    }
}
