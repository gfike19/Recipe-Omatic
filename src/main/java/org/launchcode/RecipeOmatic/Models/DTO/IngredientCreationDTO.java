package org.launchcode.RecipeOmatic.Models.DTO;

import org.launchcode.RecipeOmatic.Models.Ingredient;

import java.util.List;

public class IngredientCreationDTO {
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
