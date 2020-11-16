package com.trainer.api.dto;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.Raport;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Trainer;

import java.util.ArrayList;
import java.util.Collection;

public class MenteeDTO {

    private String email;
    private Profile profile;
    private String target;

    private Dimensions dimensions;

    private Collection<Trainer> trainers;
    private Collection<Raport> raports;
    private Collection<WeekPlan> weekPlans;


    public Collection<Trainer> getTrainers() {
        return trainers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Raport> getRaports() {
        return raports;
    }

    public void setRaports(Collection<Raport> raports) {
        this.raports = raports;
    }

    public Collection<WeekPlan> getWeekPlans() {
        return weekPlans;
    }

    public void setWeekPlans(Collection<WeekPlan> weekPlans) {
        this.weekPlans = weekPlans;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setTrainers(Collection<Trainer> trainers) {
        this.trainers = new ArrayList<>();
    }
}
