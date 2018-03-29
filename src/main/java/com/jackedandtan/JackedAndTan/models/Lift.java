package com.jackedandtan.JackedAndTan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Lift {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20)
    private String lift;

    @NotNull
    @Size(min=1, message = "You gotta lift something, bro!")
    private String weight;

    private T1LiftType type;

    public Lift(String lift, String weight) {
        this.lift = lift;
        this.weight = weight;
    }
    public Lift(){
    }



    public int getId(){
        return id;
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

    public T1LiftType getType() {
        return type;
    }

    public void setType(T1LiftType type) {
        this.type = type;
    }
}
