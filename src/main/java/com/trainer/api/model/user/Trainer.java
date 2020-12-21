package com.trainer.api.model.user;

import com.trainer.api.model.*;
import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.model.plan.WeekPlan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
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
    private List<Invite> invites;
    private List<Meal> meals;

    @DBRef(lazy = true)
    private List<Mentee> mentees;

    @DBRef(lazy = true)
    private Collection<WeekPlan> weekPlans;

    @DBRef(lazy = true)
    private Collection<DailyPlan> dailyPlans;

    @DBRef(lazy = true)
    private Collection<MealPlan> mealPlans;

    public Trainer() {
    }

    public Trainer(String _id,
                   String email,
                   Profile profile,
                   Dimensions dimensions,
                   Advertisment advertisment,
                   List<Invite> invites,
                   List<Meal> meals,
                   List<Mentee> mentees,
                   Collection<WeekPlan> weekPlans,
                   Collection<DailyPlan> dailyPlans,
                   Collection<MealPlan> mealPlans) {
        this._id = _id;
        this.email = email;
        this.profile = profile;
        this.dimensions = dimensions;
        this.advertisment = advertisment;
        this.invites = invites;
        this.meals = meals;
        this.mentees = mentees;
        this.weekPlans = weekPlans;
        this.dailyPlans = dailyPlans;
        this.mealPlans = mealPlans;
    }


    public Collection<WeekPlan> getWeekPlans() {
        return weekPlans;
    }

    public void setWeekPlans(Collection<WeekPlan> weekPlans) {
        this.weekPlans = weekPlans;
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
        return meals == null ? new ArrayList<>() : meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Mentee> getMentees() {
        return mentees == null ? new ArrayList<>() : mentees;
    }

    public List<Mentee> addMentee(Mentee mentee){
        if(mentees == null)
            mentees = new ArrayList<>();
        mentees.add(mentee);
        return mentees;
    }
    public void setMentees(List<Mentee> mentees) {
        this.mentees = mentees;
    }


    public List<Invite> getInvites() {
        return invites;
    }

    public void setInvites(List<Invite> invite) {
        this.invites = invite;
    }

    public List<Invite> addInvitation(Invite invitation){
        if(invites == null)
            invites = new ArrayList<>();
        invites.add(invitation);
        return invites;
    }

    public Collection<DailyPlan> getDailyPlans() {
        return dailyPlans;
    }

    public void setDailyPlans(Collection<DailyPlan> dailyPlans) {
        this.dailyPlans = dailyPlans;
    }

    public Collection<MealPlan> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(Collection<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }
}
