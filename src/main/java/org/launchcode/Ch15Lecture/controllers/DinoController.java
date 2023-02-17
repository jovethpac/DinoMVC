package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoData;
import org.launchcode.Ch15Lecture.data.DinosaurRepository;
import org.launchcode.Ch15Lecture.models.Dinosaur;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Let's create a DinosaurRepository field so that we can access all of the CRUD methods we need to save/read dinosaur data from the database...so we can use.findAll
    //syntax: private Type name
    @Autowired  //mandatory to add before privateDinosaurRepository
    private DinosaurRepository dinosaurRepository; //I can name this variable any name I want like Model model

    //this is a method that handles get requests at the /dino path
    @GetMapping
    public String dino(Model model){//dino is any made up name, should match what it wants to display
        //let's pass in a list of ALL the Dinos in our data layer. point to the DinoData under data and reference the METHOD
        //model.addAttribute("allDinos", DinoData.getAllDinos()); no longer needed
        model.addAttribute("allDinos", dinosaurRepository.findAll()); //this works because this is an instance that we can use .findAll on
        return"dino/index";//needs to have both locations
    }

    @GetMapping("add")
    //render the form created in dino/add
    public String displayAddDinoForm(){
        return "dino/add";
    }

    @PostMapping("add") //this method processes the addDinoForm and displays it back to dino/add
    public String processAddDinoForm(Model model, @ModelAttribute @Valid Dinosaur newDinoObj,
                                    Errors errors){//Errors error needs to go last
        //now that we have the 3 necessary pieces of data we need from the form,
        //let's create a Dinosaur object using this data: Dinosaur newDinoObj = new Dinosaur(species, diet, aquatic);
        //replace the above line with model binding: @ModelAttribute Dinosaur newDinoObj
        // the above creates the new dino object right at the parameter
        // Dinosaur newDinoObj = new Dinosaur(species, diet, aquatic);
//Dinosaur is Type and newDinoObj is nanme
        //now that we are validating the post request data via model validation, we need to
        //check that the data is passing using this Errors object before adding the dino to the
        //allDinos list
        if(errors.hasErrors()) {

            //before we re-render out the dino/add view, let's pass in an error message the view so that the user gets some feedback
            //about what went wrong
            model.addAttribute("errorMsg","The species must contain at least 3 characters!");
            return "dino/add";
        }
        //what should we do with this dinosaur OBJECT? Add it to the ArrayList in the data layer
        //call the method addDino from Dinodata
        DinoData.addDino(newDinoObj);

        //now that we have processed our post request and stored our Dinosaur object in our allDinos list
        //what page should we render now?
        //send to dino/index because that's where we'll see the list of dinosaurs we're looking for
        //need to put Model model in the parameter at the very beginning
        //anytime we RENDER dino/index
        //so that our ThymeLeaf template can render ALL of dinos in the table
       // model.addAttribute("allDinos", DinoData.getAllDinos()); removed because no longer needed after redirect was added
        //it would be redundant to have the other model.addAttribute because redirect takes you to dino method that has its own model.addAttribute

        dinosaurRepository.save(newDinoObj); //if we add a dinosaur via the form, this will now be persistently stored in the database which will maintain the data

        //return "dino/index";
        return "redirect:"; //as soon we as finish processing the method above (processAddDinoForm), it will redirect us back to the root path or the index page. it will send a get request over to the dino method which is /dino path
        // ...this will sends us back to the home page to /dino and adds that new dinosaur object there...sends a get request back to localhost:8080/dino, everytime we send a get request to /dino, we go to the dino method
        // which displays all of the dinos
    }
}
