package com.trainer.api.model;

import com.trainer.api.model.user.Mentee;

public class Invite {
    private Mentee mentees;

    public Invite(Mentee mentees) {
        this.mentees = mentees;
    }

    public Mentee getMentees() {
        return mentees;
    }

    public void setMentees(Mentee mentees) {
        this.mentees = mentees;
    }
}
