package com.trainer.api.model;

import com.trainer.api.model.user.Mentee;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "advertisment")
public class Advertisment {
    @Id
    private String _id;
    private Boolean active;
    private Double price;
    private String description;
    private Integer dietGoals;

    @DBRef(lazy = true)
    private Mentee mentee;

    public Advertisment() {
    }

    public Advertisment(String _id,
                        Boolean active,
                        Double price,
                        String description,
                        Integer dietGoals,
                        Mentee mentee) {
        this._id = _id;
        this.active = active;
        this.price = price;
        this.description = description;
        this.dietGoals = dietGoals;
        this.mentee = mentee;
    }

    public Mentee getMentee() {
        return mentee;
    }

    public void setMentee(Mentee mentee) {
        this.mentee = mentee;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public Integer getDietGoals() {
        return dietGoals;
    }

    public void setDietGoals(Integer dietGoals) {
        this.dietGoals = dietGoals;
    }
}
