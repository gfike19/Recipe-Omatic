package org.launchcode.RecipeOmatic.Models.DTO;

import org.launchcode.RecipeOmatic.Models.Ingredient;
import org.launchcode.RecipeOmatic.Models.Recipe;

import javax.validation.constraints.NotNull;

public class RecipeDTO {

    @NotNull
    private Recipe recipe;

    @NotNull
    private Ingredient ingredient;

    public RecipeDTO() { }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() { return ingredient; }

    public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }
}
