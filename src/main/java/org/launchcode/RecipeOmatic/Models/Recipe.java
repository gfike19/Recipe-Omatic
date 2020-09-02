package org.launchcode.RecipeOmatic.Models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @Column
    private String name;

    @ManyToMany
    @JoinTable
    private final List<Ingredient> ingredients = new ArrayList<>();

    @Column
    private String directions;

    @ManyToOne
    @NotNull(message = "Category is required")
    private RecipeCategory recipeCategory;

    public Recipe(){}

    public Recipe(String directions, RecipeCategory recipeCategory) {
        super();
        this.directions = directions;
        this.recipeCategory = recipeCategory;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
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

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }
}
