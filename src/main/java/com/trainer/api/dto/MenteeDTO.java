package com.trainer.api.dto;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.Raport;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Trainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenteeDTO {

    private String _id;
    private String email;
    private Profile profile;
    private String target;

    private Dimensions dimensions;

    private List<Trainer> trainers;
    private Collection<Raport> raports;
    private Collection<WeekPlan> weekPlans;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Trainer> getTrainers() {
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

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = new ArrayList<>();
    }
}
