package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.DTO.RecipeDTO;
import org.launchcode.RecipeOmatic.DTO.RecipeType;
import org.launchcode.RecipeOmatic.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Recipe;
import org.launchcode.RecipeOmatic.RecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("ingredients", "Ingredients");
        columnChoices.put("recipes", "Recipes");
        columnChoices.put("types", "Types");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("recipe", recipeRepository.findAll());
        model.addAttribute("ingredient", ingredientRepository.findAll());
        model.addAttribute("type", RecipeType.values());
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipes with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "recipeList";
    }

    @GetMapping(value = "type")
    public String displayByType(Model model){
        model.addAttribute("type", RecipeType.values());
        return "categoryList";
    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {
        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            if(recipe.getType() == recipe.getType()){
                model.addAttribute("recipe", recipe);
                RecipeDTO recipeDTO = new RecipeDTO();
                model.addAttribute("recipeDTO", recipeDTO);
            }
            return "view";
        } else {
            model.addAttribute("title", "Invalid recipe ID: " + recipeId);
            return "redirect:";
        }
    }
}
