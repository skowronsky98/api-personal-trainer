package com.trainer.api.model.plan;

import com.trainer.api.model.Meal;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "dailyplan")
public class DailyPlan {
    @Id
    private String _id;
    private String name;
    private int numberOfDay;
    @DBRef(lazy = true)
    private Collection<MealPlan> mealPlans;
    private String bio;

    public DailyPlan() {
    }

    public DailyPlan(String _id,
                     String name,
                     int numberOfDay,
                     Collection<MealPlan> mealPlans,
                     String bio) {
        this._id = _id;
        this.name = name;
        this.numberOfDay = numberOfDay;
        this.mealPlans = mealPlans;
        this.bio = bio;
    }

    @PersistenceConstructor
    public DailyPlan( String name,
                      int numberOfDay,
                      Collection<MealPlan> mealPlans,
                      String bio){

        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addMealPlan(MealPlan mealPlan){
        if(mealPlans == null)
            mealPlans = new ArrayList<>();
        mealPlans.add(mealPlan);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
