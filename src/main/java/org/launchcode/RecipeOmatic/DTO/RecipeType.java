package org.launchcode.RecipeOmatic.DTO;

public enum RecipeType {

    MEXICAN("Mexican"),
    AMERICAN("American"),
    ITALIAN("Italian"),
    DESSERT("Dessert");

    private final String displayName;

    RecipeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
