package org.launchcode.RecipeOmatic.Models;

import org.launchcode.RecipeOmatic.Models.Recipe;

import java.util.ArrayList;

public class RecipeData {

    public static ArrayList<Recipe> findByColumnAndValue(String column, String value, Iterable<Recipe> recipes) {

        ArrayList<Recipe> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Recipe>) recipes;
        }

        if (column.equals("all")){
            results = findByValue(value, recipes);
            return results;
        }
        for (Recipe recipe : recipes) {

            String aValue = getFieldValue(recipe, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(recipe);
            }
        }

        return results;
    }

    public static String getFieldValue(Recipe recipe, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = recipe.getName();
        } else if (fieldName.equals("category")){
            theValue = recipe.getRecipeCategory().toString();
        } else {
            theValue = recipe.getIngredients().toString();
        }

        return theValue;
    }

    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> recipes) {
        String lower_val = value.toLowerCase();

        ArrayList<Recipe> results = new ArrayList<>();

        for (Recipe recipe : recipes) {

            if (recipe.getName().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.getIngredients().toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.getRecipeCategory().toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            } else if (recipe.toString().toLowerCase().contains(lower_val)) {
                results.add(recipe);
            }

        }

        return results;
    }

}
