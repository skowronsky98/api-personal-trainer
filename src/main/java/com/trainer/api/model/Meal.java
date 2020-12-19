package com.trainer.api.model;

public class Meal {

    private Long idMeal;
    private String name;
    private String components;
    private String recipe;
    private double kcal;

    public Meal() { }

    public Meal(Long idMeal,
                String name,
                String components,
                String recipe,
                double kcal) {
        this.idMeal = idMeal;
        this.name = name;
        this.components = components;
        this.recipe = recipe;
        this.kcal = kcal;
    }

    public Long getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Long idMeal) {
        this.idMeal = idMeal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }
}
