package org.launchcode.Ch15Lecture.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dinosaur {
    //FIELDS
    @Id
    @GeneratedValue  //both mean primary key
    private int id;
    //private static int nextId = 1;  no longer needed. replaced by @Id and @GeneratedValue

    //first step to model validation so that species is never left blank by user; @NotNull is a safeguard
    //go back to DinoController and add @Valid
    @NotBlank
    @Size(min=3)
    private String species;
    @NotNull
    private String diet;
    @NotNull
    private String aquatic;

    //CONSTRUCTOR
//    public Dinosaur(){   no longer needed. replaced by @Id and @GeneratedValue
//        id = nextId;//remember that this has a getter
//        nextId++;
//}
    public Dinosaur() {}//still needs an empty constructor

    public Dinosaur(String species, String diet, String aquatic) {
       // this();//refers to the id  no longer needed. replaced by @Id and @GeneratedValue
        this.species = species;
        this.diet = diet;
        this.aquatic = aquatic;
    }

    //GETTER SETTER METHODS

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String isAquatic() {
        return aquatic;
    }

    public void setAquatic(String aquatic) {
        this.aquatic = aquatic;
    }

    public int getId() {
        return id;
    }
}
