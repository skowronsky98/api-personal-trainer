package com.trainer.api.dao;

import com.trainer.api.model.user.Mentee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MenteeDao {
    @Autowired
    private MenteeRepo menteeRepo;

    public Collection<Mentee> getAllMentee(){
        return menteeRepo.findAll();
    }

    public Mentee addMentee(Mentee mentee){
        return menteeRepo.save(mentee);
    }

    public Optional<Mentee> getMenteeByID(String idMentee){
        return menteeRepo.findById(idMentee);
    }

}
