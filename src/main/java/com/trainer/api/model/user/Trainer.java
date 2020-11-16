package com.trainer.api.model.user;

import com.trainer.api.model.Advertisment;
import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Meal;
import com.trainer.api.model.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "trainer")
public class Trainer {

    @Id
    private String _id;
    @Indexed(unique=true)
    private String email;

    private Profile profile;
    private Dimensions dimensions;
    private Advertisment advertisment;
    private List<Meal> meals;

    @DBRef(lazy = true)
    private List<Mentee> mentees;

    public Trainer() {
    }

    public Trainer(String _id, String email, Profile profile, Dimensions dimensions, Advertisment advertisment, List<Meal> meals, List<Mentee> mentees) {
        this._id = _id;
        this.email = email;
        this.profile = profile;
        this.dimensions = dimensions;
        this.advertisment = advertisment;
        this.meals = meals;
        this.mentees = mentees;
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
