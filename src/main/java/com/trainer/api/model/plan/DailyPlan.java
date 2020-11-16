package com.trainer.api.model.plan;

import java.util.Collection;

public class DailyPlan {
    private int numberOfDay;
    private Collection<MealPlan> mealPlans;
    private String bio;

    public DailyPlan() {
    }

    public DailyPlan(int numberOfDay, Collection<MealPlan> mealPlans, String bio) {
        this.numberOfDay = numberOfDay;
        this.mealPlans = mealPlans;
        this.bio = bio;
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
