package com.trainer.api.dto;

import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TrainerDTO {

    private String email;
    private Profile profile;


    private Collection<Meal> meals;
    private Dimensions dimensions;
    private Advertisment advertisment;

    private Collection<Mentee> mentees;


    public Collection<Mentee> getMentees() {
        return mentees;
    }

    public void setMentees(Collection<Mentee> mentees) {
        this.mentees = new ArrayList<>();
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

    public Collection<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Collection<Meal> meals) {
        this.meals = meals;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Advertisment getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(Advertisment advertisment) {
        this.advertisment = advertisment;
    }
}
