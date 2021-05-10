package com.trainer.api.dto;

import com.trainer.api.enums.DietGoals;

public class AdvertismentDTO {
    private String _id;

    private Boolean active;
    private Double price;
    private String description;
    private Integer dietGoals;

    //private MenteeDTO mentee;

//    public MenteeDTO getMentee() {
//        return mentee;
//    }
//
//    public void setMentee(MenteeDTO mentee) {
//        this.mentee = mentee;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getDietGoals() {
        return dietGoals;
    }

    public void setDietGoals(Integer dietGoals) {
        this.dietGoals = dietGoals;
    }
}
