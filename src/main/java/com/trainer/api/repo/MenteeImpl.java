package com.trainer.api.repo;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.model.user.Mentee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MenteeImpl {
    @Autowired
    private MenteeRepo menteeRepo;

    public Collection<Mentee> getAllMentee(){
        return menteeRepo.findAll();
    }

    public Mentee addMentee(Mentee mentee){
        return menteeRepo.save(mentee);
    }

    public Mentee getMentee(String idMentee){
        return menteeRepo
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("id mentee: "+idMentee));
    }

    public Optional<Mentee> getMenteeByID(String idMentee){
        return menteeRepo.findById(idMentee);
    }

}
