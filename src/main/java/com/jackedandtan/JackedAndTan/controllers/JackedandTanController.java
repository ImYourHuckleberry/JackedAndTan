package com.jackedandtan.JackedAndTan.controllers;

import com.jackedandtan.JackedAndTan.models.Lift;
import com.jackedandtan.JackedAndTan.models.LiftData;
import com.jackedandtan.JackedAndTan.models.T1LiftType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("jackedandtan")
public class JackedandTanController {

    // request path "/jackedandtan"


    @RequestMapping(value="" )
    public String index(Model model){

        model.addAttribute("lifts", LiftData.getAll());
        //will pass data from controller to view this time passing an array list
        model.addAttribute("title", "One Rep Max");
        return "templatesforjackedandtancontroller/index";
        //maybeneed jackedandtancontroller we will see
        // return index refers to the template name we are rendering (index)
    }


    @RequestMapping(value="addlift", method = RequestMethod.GET)
    public String displayAddLiftForm(Model model){
        model.addAttribute("title", "Add Lift");
        model.addAttribute(new Lift());
        model.addAttribute("t1LiftTypes", T1LiftType.values());
        //by passing empty lift we can use properties to render form corrently
        return "templatesforjackedandtancontroller/addlift";


    }
    @RequestMapping(value="addlift", method= RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid Lift newLift,
                                 Errors errors, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Lift");
            return "templatesforjackedandtancontroller/addlift";
        }

        LiftData.add(newLift);
        /**
         *
         *Lift newLift = newLift();    (calling constructor)
         * newLift.setName(Request.getParameter("name"));
         *          ^ framework will go to request thats come in
         *          look for parameter that corresponds to same names as field
         * newLift.setWeight(Request.getParameter("weight"));
         *          ^ same as above
         *          this is why is is important for the names pf teh fields to match up with the names of the form field in the class
         *          must match exactly
         *  validation is possible because of this
         *  this is MODEL BINDING
         *
         *
         *
         */

        return "redirect:";
    }
    //^^^includes model binding between liftWeight and liftName
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveLiftForm(Model model) {
        model.addAttribute("lifts", LiftData.getAll());
        model.addAttribute("title", "Remove Lift");
        return "templatesforjackedandtancontroller/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveLiftForm(@RequestParam int[] liftIds) {

        for (int liftId : liftIds){
            LiftData.remove(liftId);
        }

        return "redirect:";
    }
}



