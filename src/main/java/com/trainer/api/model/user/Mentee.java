package com.trainer.api.model.user;

import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.Raport;
import com.trainer.api.model.plan.WeekPlan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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

    @DBRef(lazy = true)
    private Advertisment advertisment;

    private Collection<Raport> raports;

    @DBRef(lazy = true)
    private Collection<WeekPlan> weekPlans;

    @DBRef(lazy = true)
    private List<Trainer> assignedTainers;

    public Mentee() {
    }

    public Mentee(String _id,
                  String email,
                  Profile profile,
                  String target,
                  Dimensions dimensions,
                  Advertisment advertisment,
                  Collection<Raport> raports,
                  Collection<WeekPlan> weekPlans,
                  List<Trainer> assignedTainers) {
        this._id = _id;
        this.email = email;
        this.profile = profile;
        this.target = target;
        this.dimensions = dimensions;
        this.advertisment = advertisment;
        this.raports = raports;
        this.weekPlans = weekPlans;
        this.assignedTainers = assignedTainers;
    }

    public Advertisment getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(Advertisment advertisment) {
        this.advertisment = advertisment;
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
        return raports == null ? new ArrayList<>() : raports;
    }

    public void setRaports(Collection<Raport> raports) {
        this.raports = raports;
    }

    public Collection<WeekPlan> getWeekPlans() {
        return weekPlans == null ? new ArrayList<>() : weekPlans;
    }

    public void setWeekPlans(Collection<WeekPlan> weekPlans) {
        this.weekPlans = weekPlans;
    }

    public List<Trainer> getAssignedTainers() {
        return assignedTainers == null ? new ArrayList<>() : assignedTainers;
    }

    public List<Trainer> addTrainer(Trainer trainer){
        if(assignedTainers == null)
            assignedTainers = new ArrayList<>();
        assignedTainers.add(trainer);
        return assignedTainers;
    }

    public void addWeekPlan(WeekPlan weekPlan){
        if (weekPlans == null)
            weekPlans = new ArrayList<>();
        weekPlans.add(weekPlan);
    }

    public void setAssignedTainers(List<Trainer> assignedTainers) {
        this.assignedTainers = assignedTainers;
    }
}
