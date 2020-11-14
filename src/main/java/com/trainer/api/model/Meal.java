package com.trainer.api.model;

import org.springframework.data.annotation.Id;


public class Meal {

    @Id
    private Long idMeal;

    private String title;
    private String name;
    private String recipe;

    public Meal() { }

    public Meal(Long idMeal, String title, String name, String recipe) {
        this.idMeal = idMeal;
        this.title = title;
        this.name = name;
        this.recipe = recipe;
    }

    public Long getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Long idMeal) {
        this.idMeal = idMeal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recepie) {
        this.recipe = recepie;
    }
}
