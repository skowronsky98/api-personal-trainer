package com.trainer.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mentee")
public class Mentee {

    @Id
    private String _id;
    private String name;
    private String surname;
    private String bio;

    private Dimensions dimensions;

    @DBRef(lazy = true)
    private List<Trainer> trainers;

    public Mentee(String _id, String name, String surname, String bio, Dimensions dimensions, List<Trainer> trainers) {
        this._id = _id;
        this.name = name;
        this.surname = surname;
        this.bio = bio;
        this.dimensions = dimensions;
        this.trainers = trainers;
    }

    public Mentee() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
