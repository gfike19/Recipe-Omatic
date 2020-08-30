package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.DTO.RecipeDTO;
import org.launchcode.RecipeOmatic.DTO.RecipeType;
import org.launchcode.RecipeOmatic.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Ingredient;
import org.launchcode.RecipeOmatic.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("")
    public String displayAllRecipes(Model model) {
        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "recipes/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("types", RecipeType.values());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute Recipe newRecipe, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            return "recipes/create";
        }
//        List<Ingredient> item = (List<Ingredient>) ingredientRepository.findAll();
//        newRecipe.setIngredients(item);
//        model.addAttribute("ingredients", ingredientRepository.findAll());
        recipeRepository.save(newRecipe);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model){
        model.addAttribute("title", "Delete Recipe");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/delete";
    }

    @PostMapping("delete")
    public String processDeleteRecipeForm(@RequestParam(required = false) int[] recipeId){
        if(recipeId != null){
            for(int id : recipeId){
                recipeRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {
        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            RecipeDTO recipeDTO = new RecipeDTO();
            model.addAttribute("recipeDTO", recipeDTO);
            return "recipes/view";
        } else {
            model.addAttribute("title", "Invalid recipe ID: " + recipeId);
            return "redirect:";
        }
    }

    @GetMapping("recipeList")
    public String viewAllRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/recipeList";
    }

}
