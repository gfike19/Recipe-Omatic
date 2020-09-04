package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Models.DTO.RecipeDTO;
import org.launchcode.RecipeOmatic.Models.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeCategoryRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Models.Recipe;
import org.launchcode.RecipeOmatic.Models.RecipeData;
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

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {
        columnChoices.put("all", "All");
        columnChoices.put("ingredients", "Ingredients");
        columnChoices.put("recipes", "Recipes");
        columnChoices.put("categories", "Categories");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "list";
    }

//    @RequestMapping(value = "recipes")
//    public String listRecipesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
////        Iterable<Recipe> recipes;
////        if (column.toLowerCase().equals("all")){
////            recipes = recipeRepository.findAll();
////            model.addAttribute("title", "All Recipes");
////        } else {
////            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
////        }
////        model.addAttribute("columns", columnChoices);
////        model.addAttribute("recipes", recipes);
////        model.addAttribute("categories", recipeCategoryRepository.findAll());
////        model.addAttribute("ingredients", ingredientRepository.findAll());
//
//        return "recipeList";
//    }

    @GetMapping(value = "categories")
    public String displayByType(Model model){
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "categoryList";
    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {
        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            if(recipe.getRecipeCategory() == recipe.getRecipeCategory()){
                model.addAttribute("recipe", recipe);
                RecipeDTO recipeDTO = new RecipeDTO();
                model.addAttribute("recipeDTO", recipeDTO);
                model.addAttribute("ingredients", ingredientRepository.findAll());
            }
            return "recipeList";
        } else {
            model.addAttribute("title", "Invalid recipe ID: " + recipeId);
            return "redirect:";
        }
    }
}
