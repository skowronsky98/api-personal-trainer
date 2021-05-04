package com.trainer.api.dto;

import com.trainer.api.enums.DietGoals;
import com.trainer.api.model.Profile;
import com.trainer.api.model.user.Mentee;

public class AdvertismentDTO {
    private String _id;

    private String firstname;
    private String surname;
    private Integer age;
    private String bio;

    private Boolean active;
    private Double price;
    private String description;
    private DietGoals dietGoals;

    private MenteeDTO mentee;

    public MenteeDTO getMentee() {
        return mentee;
    }

    public void setMentee(MenteeDTO mentee) {
        this.mentee = mentee;
    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public DietGoals getDietGoals() {
        return dietGoals;
    }

    public void setDietGoals(DietGoals dietGoals) {
        this.dietGoals = dietGoals;
    }
}
