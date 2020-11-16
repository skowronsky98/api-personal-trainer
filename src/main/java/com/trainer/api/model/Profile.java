package com.trainer.api.model;

public class Profile {
    private String firstname;
    private String surname;
    private Integer age;
    private String bio;

    public Profile() {
    }

    public Profile(String firstname, String surname, Integer age, String bio) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.bio = bio;
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
}
