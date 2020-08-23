package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Recipe;
import org.launchcode.RecipeOmatic.RecipeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.launchcode.RecipeOmatic.Controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;


    @RequestMapping("")
    public String search(Model model){
        model.addAttribute("columns", columnChoices);
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String type, @RequestParam String term){
        Iterable<Recipe> recipes;
        if(term.toLowerCase().equals("all") || term.equals("")){
            recipes = recipeRepository.findAll();
        }else {
            recipes = RecipeData.findByColumnAndValue(type, term, recipeRepository.findAll());
        }
        model.addAttribute("column", "choices");
        model.addAttribute("title", "Recipes with " + columnChoices.get(type) + ": " + term);
        model.addAttribute("recipes", recipes);
        return "search";
    }
}
