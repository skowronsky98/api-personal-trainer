package com.trainer.api.model.plan;

import com.trainer.api.model.Meal;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mealplan")
public class MealPlan {
    @Id
    private String _id;
    private String name;
    private Meal meal;
    private String type;

    public MealPlan() {
    }

    public MealPlan(String _id, String name, Meal meal, String type) {
        this._id = _id;
        this.name = name;
        this.meal = meal;
        this.type = type;
    }

    @PersistenceConstructor
    public MealPlan(String name, Meal meal, String type){
        this.name = name;
        this.meal = meal;
        this.type = type;
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
