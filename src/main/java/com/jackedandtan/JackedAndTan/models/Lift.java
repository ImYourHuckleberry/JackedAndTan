package com.jackedandtan.JackedAndTan.models;

public class Lift {
    private String lift;
    private String weight;
    private int liftId;
    //unique number that will identify each object in cheese class as differentand
    //unique
    private static int nextId=1;


    public Lift(String lift, String weight) {
        this();
        //says call the default constructor for the given class
        //this will call the id field
        this.lift = lift;
        this.weight = weight;
    }
    public Lift(){
        liftId=nextId;
        nextId++;
        //gets new number ere time
    }

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Lift.nextId = nextId;
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
