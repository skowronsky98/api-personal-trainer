package com.trainer.api.controller;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.service.MenteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/trainer/mentee")
public class MenteeController {
    @Autowired
    private MenteeService menteeService;

    @GetMapping
    public Collection<MenteeDTO> getAllMentee(){
        return menteeService.getAllMenteeDTO();
    }

    @PostMapping
    public Mentee addMentee(@RequestBody Mentee mentee){
        return menteeService.addMentee(mentee);
    }

    @PatchMapping
    public Mentee assignTraier(@RequestHeader(value = "mid")  String idMentee,
                                      @RequestHeader(value = "tid") String idTrainer){
        return menteeService.assignTrainer(idMentee,idTrainer);
    }

}
