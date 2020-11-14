package com.trainer.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "trainer")
public class Trainer {

    @Id
    private String _id;
    private String name;
    private String surname;
    private String bio;
    private Double price;

    private List<Meal> meals;
    private Dimensions dimensions;

    @DBRef(lazy = true)
    private List<Mentee> mentees;

    public Trainer() {
    }

    public Trainer(String _id, String name, String surname, String bio, Double price, List<Meal> meals, Dimensions dimensions, List<Mentee> mentees) {
        this._id = _id;
        this.name = name;
        this.surname = surname;
        this.bio = bio;
        this.price = price;
        this.meals = meals;
        this.dimensions = dimensions;
        this.mentees = mentees;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Mentee> getMentees() {
        return mentees;
    }

    public void setMentees(List<Mentee> mentees) {
        this.mentees = mentees;
    }
}
