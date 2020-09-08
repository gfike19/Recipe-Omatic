package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Models.DTO.IngredientCreationDTO;
import org.launchcode.RecipeOmatic.Models.DTO.RecipeDTO;
import org.launchcode.RecipeOmatic.Models.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeCategoryRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Models.Ingredient;
import org.launchcode.RecipeOmatic.Models.Recipe;
import org.launchcode.RecipeOmatic.Models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

//    @GetMapping
//    public String displayRecipes(@RequestParam(required = false) Integer categoryId, Model model) {
//
//        if (categoryId == null) {
//            model.addAttribute("title", "All Recipes");
//            model.addAttribute("recipes", recipeRepository.findAll());
//        } else {
//            Optional<RecipeCategory> result = recipeCategoryRepository.findById(categoryId);
//            if (result.isEmpty()) {
//                model.addAttribute("title", "Invalid Category ID: " + categoryId);
//            } else {
//                RecipeCategory category = result.get();
//                model.addAttribute("title", "Recipes in category: " + category.getName());
//                model.addAttribute("recipes", category.getRecipes());
//            }
//        }
//
//        return "recipes/index";
//    }
    @GetMapping("")
    public String displayAllRecipes(Model model) {
        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors,
                                          Model model, @ModelAttribute Ingredient newIngredient){
        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            return "recipes/create";
        }
        model.addAttribute("newIngredient", newIngredient);
        List<Ingredient> ingredients = new ArrayList<>();
        model.addAttribute("quantity", newIngredient.getQuantity());
        model.addAttribute("measurement", newIngredient.getMeasurement());
        ingredients.add(newIngredient);
        model.addAttribute("ingredients", ingredients);
        ingredientRepository.save(newIngredient);
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
            model.addAttribute("ingredients", ingredientRepository.findAll());
            model.addAttribute("categories", recipeCategoryRepository.findAll());
            return "recipes/view";
        } else {
            model.addAttribute("title", "Invalid recipe ID: " + recipeId);
            return "redirect:";
        }
    }

}
