package org.launchcode.Ch15Lecture.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DinoEgg {
    @Id
    @GeneratedValue
    private int id;
    private int sizeInches;
    private int weightKg;
    private String dateLaid;


    public DinoEgg(int sizeInches, int weightKg, String dateLaid) {
        this.sizeInches = sizeInches;
        this.weightKg = weightKg;
        this.dateLaid = dateLaid;
    }

    //Alongside the normal fields, we need to include a field that establishes a relationship with the Dinosaur class
    @ManyToOne  //many dinosaur eggs to one Dinosaur
    private Dinosaur dinosaur; //lowercase dinosaur, but I can name it any variable I want
    public DinoEgg (){} //always need an empty constructor for all model classes
    public int getSizeInches() {
        return sizeInches;
    }

    public void setSizeInches(int sizeInches) {

        this.sizeInches = sizeInches;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public String getDateLaid() {
        return dateLaid;
    }

    public void setDateLaid(String dateLaid) {
        this.dateLaid = dateLaid;
    }

    public int getId() {
        return id;
    }
}
