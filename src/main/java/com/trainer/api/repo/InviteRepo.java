package com.trainer.api.repo;

import com.trainer.api.model.Invite;
import com.trainer.api.model.user.Trainer;

import java.util.List;

public interface InviteRepo {
    List<Invite> addInvite(String idMentee, String idTrainer);
    List<Invite> getInvites(String idTrainer);
}
