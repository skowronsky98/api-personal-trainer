package com.trainer.api.service;

import com.trainer.api.mapper.Mapper;
import com.trainer.api.model.Invite;
import com.trainer.api.repo.InviteRepo;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private InviteRepo inviteRepo;


    @Autowired
    private Mapper mapper;

    public List<Invite> subscribe(String idMentee, String idTrainer) {
        return inviteRepo.addInvite(idMentee,idTrainer);
    }

    public List<Invite> getInvites(String idTrainer) {
        return inviteRepo.getInvites(idTrainer);
    }


}
