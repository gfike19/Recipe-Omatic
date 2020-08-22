package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;


    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", "My Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {
        Optional<Recipe> optional = recipeRepository.findById(recipeId);
        if (optional.isPresent()) {
            Recipe recipe = (Recipe) optional.get();
            model.addAttribute("recipe", recipe);
            return "view";
        } else {
            model.addAttribute("title", "Invalid Job ID: " + recipeId);
            return "redirect:";
        }
    }

    @GetMapping("list-recipes")
    public String viewAllRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "list-recipes";
    }


}
