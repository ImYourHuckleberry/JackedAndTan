package com.jackedandtan.JackedAndTan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("jackedandtan")
public class JackedandTanController {
    static ArrayList<String> lifts = new ArrayList<>();
    // request path "/jackedandtan"
    @RequestMapping(value="" )
    public String index(Model model){

        model.addAttribute("lifts", lifts);
        //will pass data from controller to view this time passing an array list
        model.addAttribute("title", "One Rep Max");
        return "templatesforjackedandtancontroller/index";
        // return index refers to the template name we are rendering (index)
    }
    @RequestMapping(value="addlift", method = RequestMethod.GET)
    public String displayAddLiftForm(Model model){
        model.addAttribute("title", "Add Lift");
        return "templatesforjackedandtancontroller/addlift";


    }
    @RequestMapping(value="addlift", method= RequestMethod.POST)
    public String processAddForm(@RequestParam() String liftName) {
        //RequestParam says it shoud look for the parameter with the same name found in addlift and insert
        lifts.add(liftName);

        return "redirect:";
    }
}



