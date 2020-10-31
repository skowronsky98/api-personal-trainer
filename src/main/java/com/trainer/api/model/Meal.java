package com.trainer.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeal;

    private String title;
    private String name;
    private String recepie;

    public Meal() { }

    public Meal(Long idMeal, String title, String name, String recepie) {
        this.idMeal = idMeal;
        this.title = title;
        this.name = name;
        this.recepie = recepie;
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

    public String getRecepie() {
        return recepie;
    }

    public void setRecepie(String recepie) {
        this.recepie = recepie;
    }
}
