package org.launchcode.RecipeOmatic;

import javax.persistence.Entity;

@Entity
public class Ingredient extends AbstractEntity{

    private int quantity;

    private String ingredient;

    public Ingredient(){}

    public Ingredient(int quantity, String ingredient){
        super();
        this.quantity = quantity;
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
