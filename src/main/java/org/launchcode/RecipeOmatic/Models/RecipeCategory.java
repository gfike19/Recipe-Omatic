package org.launchcode.RecipeOmatic.Models;

import org.launchcode.RecipeOmatic.Models.AbstractEntity;
import org.launchcode.RecipeOmatic.Models.Recipe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeCategory extends AbstractEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "recipeCategory")
    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeCategory(){}

    public RecipeCategory(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
