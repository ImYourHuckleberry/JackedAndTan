package com.jackedandtan.JackedAndTan.models;

import java.util.ArrayList;

public class LiftData {

    static ArrayList<Lift> lifts = new ArrayList<>();

    public static ArrayList<Lift>getAll(){
        return lifts;
    }
    //getAll
    public static void(Lift newLift){
        lifts.add(newLift);
    }
    //add

    public static void remove (int id){
        Lift liftToRemove=getById(id);
        lifts.remove(liftToRemove);


    }

    //remove
    public static Lift getById(int id){
        Lift theLift = null;
        for(Lift candidateLift : lifts){
            if(candidateLift.getLiftId()==id){
                theLift=candidateLift;
            }
        }

        return theLift;
    }
    //getById

}

