package org.launchcode.RecipeOmatic.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @Column
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private final List<Recipe> recipes = new ArrayList<>();

    @Column
    private String measurement;

    @Column
    private Integer quantity;

    public Ingredient(){}

    public Ingredient(String name, String measurement, Integer quantity){
        super();
        this.name = name;
        this.measurement = measurement;
        this.quantity = quantity;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
