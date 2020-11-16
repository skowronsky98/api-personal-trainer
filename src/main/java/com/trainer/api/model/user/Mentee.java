package com.trainer.api.model.user;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.Raport;
import com.trainer.api.model.plan.WeekPlan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Document(collection = "mentee")
public class Mentee {

    @Id
    private String _id;
    @Indexed(unique=true)
    private String email;

    private Profile profile;
    private String target;
    private Dimensions dimensions;
    private Collection<Raport> raports;
    private Collection<WeekPlan> weekPlans;

    @DBRef(lazy = true)
    private List<Trainer> trainers;

    public Mentee() {
    }

    public Mentee(String _id, String email, Profile profile, String target, Dimensions dimensions, Collection<Raport> raports, Collection<WeekPlan> weekPlans, List<Trainer> trainers) {
        this._id = _id;
        this.email = email;
        this.profile = profile;
        this.target = target;
        this.dimensions = dimensions;
        this.raports = raports;
        this.weekPlans = weekPlans;
        this.trainers = trainers;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
