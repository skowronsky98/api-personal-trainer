package com.trainer.api.dto;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Mentee;
import com.trainer.api.model.Trainer;

import java.util.ArrayList;
import java.util.List;


public class TrainerDTO {

    private String name;
    private String surname;
    private String bio;
    private Double price;

    private List<Meal> meals;
    private Dimensions dimensions;
    private List<Mentee> mentees;


    public List<Mentee> getMentees() {
        return mentees;
    }

    public void setMentees(List<Mentee> mentees) {
        if(mentees!=null){
            mentees.forEach(mentee -> {
                mentee.setTrainers(new ArrayList<>());
            });
        }
        this.mentees = mentees;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
