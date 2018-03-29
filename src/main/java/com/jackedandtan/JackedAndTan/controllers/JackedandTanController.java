package com.jackedandtan.JackedAndTan.controllers;

import com.jackedandtan.JackedAndTan.models.Lift;
import com.jackedandtan.JackedAndTan.models.T1LiftType;
import com.jackedandtan.JackedAndTan.models.data.LiftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import com.jackedandtan.JackedAndTan.models.Lift;

import javax.validation.Valid;

@Controller
@RequestMapping("jackedandtan")
public class JackedandTanController {
   @Autowired
   private LiftDao liftDao;

    @RequestMapping(value="" )
    public String index(Model model){

        model.addAttribute("lifts", liftDao.findAll());
        model.addAttribute("title", "One Rep Max");
        return "templatesforjackedandtancontroller/index";
    }


    @RequestMapping(value="addlift", method = RequestMethod.GET)
    public String displayAddLiftForm(Model model){
        model.addAttribute("title", "Add Lift");
        model.addAttribute(new Lift());
        model.addAttribute("t1LiftTypes", T1LiftType.values());
        return "templatesforjackedandtancontroller/addlift";


    }
    @RequestMapping(value="addlift", method= RequestMethod.POST)
    public String processAddLiftForm(@ModelAttribute @Valid Lift newLift,
                                     Errors errors, Model model){
        if (errors.hasErrors()){
            return "templatesforjackedandtancontroller/addlift";
        }
        liftDao.save(newLift);
        return"redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveLiftForm(Model model) {
        model.addAttribute("lifts", liftDao.findAll());
        model.addAttribute("title", "Remove Lift");
        return "templatesforjackedandtancontroller/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveLiftForm(@RequestParam int[] liftIds) {

        for (int liftId : liftIds) {
            liftDao.delete(liftId);
        }

        return "redirect:";
    }
}


