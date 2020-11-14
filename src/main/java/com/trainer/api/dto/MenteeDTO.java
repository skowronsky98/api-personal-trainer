package com.trainer.api.dto;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class MenteeDTO {

    private String name;
    private String surname;
    private String bio;

    private Dimensions dimensions;

   private List<Trainer> trainers;

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {

        trainers.forEach(trainer -> {
            trainer.setMentees(new ArrayList<>());
        });

        this.trainers = trainers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }


}
