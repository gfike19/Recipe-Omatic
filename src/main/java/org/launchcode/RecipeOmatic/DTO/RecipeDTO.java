package org.launchcode.RecipeOmatic.DTO;

import org.launchcode.RecipeOmatic.Ingredient;
import org.launchcode.RecipeOmatic.Recipe;

import java.util.List;

public class RecipeDTO {

    private Recipe recipe;

    private List<Ingredient> ingredient;

    public RecipeDTO() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }
}
