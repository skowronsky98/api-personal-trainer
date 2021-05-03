package com.trainer.api.model;

import com.trainer.api.enums.DietGoals;

public class Advertisment {
    private Boolean active;
    private Double price;
    private String description;
    private DietGoals dietGoal;

    public Advertisment() {
    }

    public Advertisment(Boolean active, Double price, String description, DietGoals dietGoal) {
        this.active = active;
        this.price = price;
        this.description = description;
        this.dietGoal = dietGoal;
    }

    public DietGoals getDietGoal() {
        return dietGoal;
    }

    public void setDietGoal(DietGoals dietGoal) {
        this.dietGoal = dietGoal;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
