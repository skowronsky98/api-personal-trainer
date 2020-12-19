package com.trainer.api.repo.impl;

import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.MenteeManager;
import com.trainer.api.manager.TrainerManager;
import com.trainer.api.model.Invite;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.InviteRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InviteImpl implements InviteRepo {

    @Autowired
    private TrainerManager trainerManager;

    @Autowired
    private MenteeManager menteeManager;

    @Override
    public List<Invite> addInvite(String idMentee, String idTrainer) {
        Trainer trainer = trainerManager
                .findById(idTrainer)
                .orElseThrow(() -> new ResourceNotFoundException("trainer not found id: "+idTrainer));
        Mentee mentee = menteeManager
                .findById(idMentee)
                .orElseThrow(() -> new ResourceNotFoundException("mentee not found id: "+idMentee));

        Invite invite = new Invite(mentee);
        List<Invite> invites = trainer.addInvitation(invite);

        trainerManager.save(trainer);
        return invites;
    }

    @Override
    public List<Invite> getInvites(String idTrainer) {
        return trainerManager.findById(idTrainer)
                .orElseThrow(() -> new ResourceNotFoundException("trainer not found id: "+idTrainer))
                .getInvites();

    }
}
