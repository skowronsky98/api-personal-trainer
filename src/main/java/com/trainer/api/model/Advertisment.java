package com.trainer.api.model;

public class Advertisment {
    private Boolean active;
    private Double price;
    private String description;

    public Advertisment() {
    }

    public Advertisment(Boolean active, Double price, String description) {
        this.active = active;
        this.price = price;
        this.description = description;
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
