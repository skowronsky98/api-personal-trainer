package com.trainer.api.model.plan;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "dailyplan")
public class DailyPlan {
    @Id
    private String _id;
    private int numberOfDay;
    @DBRef(lazy = true)
    private Collection<MealPlan> mealPlans;
    private String bio;

    public DailyPlan() {
    }

    public DailyPlan(String _id, int numberOfDay, Collection<MealPlan> mealPlans, String bio) {
        this._id = _id;
        this.numberOfDay = numberOfDay;
        this.mealPlans = mealPlans;
        this.bio = bio;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public Collection<MealPlan> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(Collection<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
