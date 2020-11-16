package com.trainer.api.model.plan;

import com.trainer.api.model.Meal;

public class MealPlan {
    private Meal meal;
    private String type;

    public MealPlan() {
    }

    public MealPlan(Meal meal, String type) {
        this.meal = meal;
        this.type = type;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
