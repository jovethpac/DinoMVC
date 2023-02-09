package org.launchcode.Ch15Lecture.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Dinosaur {
    //FIELDS
    private int id;
    private static int nextId = 1;

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
    public Dinosaur(){
        id = nextId;
        nextId++;
}
    public Dinosaur(String species, String diet, String aquatic) {
        this();//refers to the id
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
