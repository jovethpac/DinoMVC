package org.launchcode.Ch15Lecture.data;

import org.launchcode.Ch15Lecture.models.Dinosaur;

import java.util.ArrayList;
//This DinoData is no longer needed because we will now be using a CrudRepository. these are little classes that do the function of each method
public class DinoData {//serves as the stand-in database, where we store our database as we create them so we can reference them
    //here we have our list that we will use to store ALL of the dinos that we want to add in the application
    //<>contains the TYPE of data we want to store which is the Dinosaur class
    private static ArrayList<Dinosaur> allDinos =  new ArrayList<>(); //Dinosaur is the class (which has 4 characteristics)
    // we created under the models folder

    //let's create a method that acts as a getter for this private allDinos ArrayList
    public static ArrayList<Dinosaur> getAllDinos(){
        return allDinos;
    }

    //let's create a method now for adding Dinosaur object to the allDinos ArrayList
    //let's add it to the allDinos ArrayList
    //inputs:
    //outputs:
    public static void addDino(Dinosaur newDinoObj){//class followed by any name I want to call it (newDinoObj)
        //we will use this addDino method in the DinoController
    allDinos.add(newDinoObj);//I'm adding any newDinoObj to the ArrayList called allDinos
    }
}
