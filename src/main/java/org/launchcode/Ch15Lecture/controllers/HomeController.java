package org.launchcode.Ch15Lecture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.StringBufferInputStream;

//info written on home.html will show up in the homepage, we need the HomeController to actually display the page, traffic routing
@Controller
public class HomeController {
//Here we have a method that will render the home.html view at localhost:8080 (the rootpath)
    @GetMapping//basic method to FOLLOW!
    public String home() {//lines up with home.html
        return "home";//filepath of home.html
    }
}
