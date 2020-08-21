package org.launchcode.RecipeOmatic;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity{

    private List<Ingredient> ingredients = new ArrayList<>();
    private Directions directions;

    public Recipe(){}

    public Recipe(List<Ingredient> ingredients, Directions directions) {
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

    public Directions getDirections() {
        return directions;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
    }
}
