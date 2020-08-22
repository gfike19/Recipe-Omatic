package org.launchcode.RecipeOmatic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity{

    @Column
    private String name;

    @ManyToMany
    @Column
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column
    private String directions;

    public Recipe(){}

    public Recipe(List<Ingredient> ingredients, String directions) {
        super();
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
