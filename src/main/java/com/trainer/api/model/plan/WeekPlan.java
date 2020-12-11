package com.trainer.api.model.plan;


import java.util.Collection;

public class WeekPlan {
    private int numberOfWeek;
    private Collection<DailyPlan> dailyPlans;

    public WeekPlan(int numberOfWeek, Collection<DailyPlan> dailyPlans) {
        this.numberOfWeek = numberOfWeek;
        this.dailyPlans = dailyPlans;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public Collection<DailyPlan> getDailyPlans() {
        return dailyPlans;
    }

    public void setDailyPlans(Collection<DailyPlan> dailyPlans) {
        this.dailyPlans = dailyPlans;
    }
}
