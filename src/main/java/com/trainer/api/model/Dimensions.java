package com.trainer.api.model;

public class Dimensions {
    private double neck;
    private double arm;
    private double forearm;
    private double wrist;
    private double chest;
    private double waist;

    public Dimensions(double neck,
                      double arm,
                      double forearm,
                      double wrist,
                      double chest,
                      double waist) {
        this.neck = neck;
        this.arm = arm;
        this.forearm = forearm;
        this.wrist = wrist;
        this.chest = chest;
        this.waist = waist;
    }

    public double getNeck() {
        return neck;
    }

    public void setNeck(double neck) {
        this.neck = neck;
    }

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public double getForearm() {
        return forearm;
    }

    public void setForearm(double forearm) {
        this.forearm = forearm;
    }

    public double getWrist() {
        return wrist;
    }

    public void setWrist(double wrist) {
        this.wrist = wrist;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }
}
