package org.launchcode.RecipeOmatic.Models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Ingredient extends AbstractEntity {

    @Column
    private String name;

    public Ingredient(){}

    public Ingredient(String name){
        super();
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
