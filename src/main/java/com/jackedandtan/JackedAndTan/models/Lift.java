package com.jackedandtan.JackedAndTan.models;

public class Lift {
    private String lift;
    private String weight;

    public Lift(String lift, String weight) {
        this.lift = lift;
        this.weight = weight;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
