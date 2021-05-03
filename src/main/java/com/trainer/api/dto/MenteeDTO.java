package com.trainer.api.dto;

import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Raport;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Trainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MenteeDTO {

    private String _id;
    private String email;
    private String target;

    private String firstname;
    private String surname;
    private Integer age;
    private String bio;

    private Advertisment advertisment;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Advertisment getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(Advertisment advertisment) {
        this.advertisment = advertisment;
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



    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = new ArrayList<>();
    }
}
