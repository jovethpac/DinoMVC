package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoData;
import org.launchcode.Ch15Lecture.models.Dinosaur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;



//this will deal with any requests made at /dino; tenders the html files under the dino templates
@Controller
@RequestMapping("dino")//maps the whole controller to the path
public class DinoController {

    //this is a method that handles get requests at the /dino path
    @GetMapping
    public String dinoIndex(Model model){//any made up name, should match what it wants to display
        //let's pass in a list of ALL the Dinos in our data layer
        model.addAttribute("allDinos", DinoData.getAllDinos());
        //point to the DinoData under data and reference the METHOD
        return"dino/index";//needs to have both locations
    }

    @GetMapping("add")
    //render the form created in dino/add
    public String displayAddDinoForm(){
        return "dino/add";
    }

    @PostMapping("add")
    public String processAddDinoForm(Model model, @ModelAttribute @Valid Dinosaur newDinoObj,
                                    Errors error){//Errors error needs to go last
        //now that we have the 3 necessary pieces of data we need from the form,
        //let's create a Dinosaur object using this data: Dinosaur newDinoObj = new Dinosaur(species, diet, aquatic);
        //replace the below line with model binding: @ModelAttribute Dinosaur newDinoObj
        // the above creates the new dino object right at the paramenter
        // Dinosaur newDinoObj = new Dinosaur(species, diet, aquatic);

        //now that we are validating hte post request data via model validation, we need to
        //check that the data is passing using this Errors object before adding hte dino to the
        //allDinos list
        if(error.hasErrors()) {

            //before we re-render out the dino/add view, let's pass in an error message the view so that the user gets soem feedback
            //about what went wrong
            model.addAttribute("errorMsg","The species must contain at least 3 characters!");
            return "dino/add";
        }
        //what should we do with this dinosaur object? add it to the ArrayList in the data layer
        //call the method addDino from Dinodata
        DinoData.addDino(newDinoObj);

        //now that we have processed our post request and stored our Dinosaur object in our allDinos list
        //what page should we render now?
        //send to dino/index because that's where we'll see the list of dinosaurs we're looking for
        //need to put Model model in the parameter at the very beginning
        //anytime we RENDER dino/index
        //so that our ThymeLeaf template can render all of dinos in the table
        model.addAttribute("allDinos", DinoData.getAllDinos());

        return "dino/index";
    }
}
