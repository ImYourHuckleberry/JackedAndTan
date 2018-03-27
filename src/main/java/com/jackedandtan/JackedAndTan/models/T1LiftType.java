package com.jackedandtan.JackedAndTan.models;

public enum T1LiftType {

    DEADLIFT("Deadlift"),
    BENCHPRESS("Bench Press"),
    OHP("Over Head Press"),
    SQUAT("Squat"),
    BOR("Bent Over Row");

    private final String name;

    T1LiftType(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
