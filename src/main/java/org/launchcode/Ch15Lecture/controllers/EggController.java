package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoEggRepository;
import org.launchcode.Ch15Lecture.data.DinosaurRepository;
import org.launchcode.Ch15Lecture.models.DinoEgg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("egg")
public class EggController {

    @Autowired
    private DinosaurRepository dinosaurRepository; //need to have this in order to do dinosaurRepository.findAll()

    @Autowired
    private DinoEggRepository dinoEggRepository;

    //Let's make a method that is designed to  display  the egg/index view
    @GetMapping
    public String egg(){
        return "egg/index";
    }

    @GetMapping("add")
    public String displayAddEggForm(Model model){
        model.addAttribute("dinoEgg", new DinoEgg());  //dinoEgg is any variable I just made up, DinoEgg is the class
        model.addAttribute("allDinos", dinosaurRepository.findAll()); //need to have @Autowired
        return "egg/add";
    }

    //we need something to handle the post request for our form
    @PostMapping("add")
    public String processAddEggForm(Model model, @ModelAttribute @Valid DinoEgg newDinoEgg,
                                    Errors errors) {  //after @Valid you do the class and any new variable which we call newDinoEgg
        //First, we check to see if the data in the request is valid for creating a new DinoEgg object, and if it isn't valid, we should send the user back to the egg/add page and show them the form again
        if (errors.hasErrors()) {
            model.addAttribute("allDinos", dinosaurRepository.findAll());//this is needed for the dropdown
            return "egg/add";
        }
        //If we have determined that the data is valid, t hen we need to save our new DinoEgg object to the database
        //we need to have an instance of the DinoEggRepository in order to use the save method
        dinoEggRepository.save(newDinoEgg);
        return "redirect:";
    }
}
