package com.trainer.api.model.plan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trainer.api.model.user.Trainer;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "weekplan")
public class WeekPlan {
    @Id
    private String _id;
    private int numberOfWeek;
    @DBRef(lazy = true)
    private Collection<DailyPlan> dailyPlans;
    @JsonIgnore
    @DBRef(lazy = true)
    private Trainer trainer;

    public WeekPlan(String _id, Trainer trainer, int numberOfWeek, Collection<DailyPlan> dailyPlans) {
        this._id = _id;
        this.trainer = trainer;
        this.numberOfWeek = numberOfWeek;
        this.dailyPlans = dailyPlans;
    }

    @PersistenceConstructor
    public WeekPlan(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public Collection<DailyPlan> getDailyPlans() {
        if (dailyPlans == null)
            dailyPlans = new ArrayList<>();
        return dailyPlans;
    }

    public void setDailyPlans(Collection<DailyPlan> dailyPlans) {
        this.dailyPlans = dailyPlans;
    }

    public void addDailyPlan(DailyPlan dailyPlan){
        if(dailyPlans == null)
            dailyPlans = new ArrayList<>();
        dailyPlans.add(dailyPlan);
    }
}
