package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Models.DTO.RecipeDTO;
import org.launchcode.RecipeOmatic.Models.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("index")
    public String displayAllIngredients(Model model) {
        model.addAttribute("title", "All Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    @GetMapping("create")
    public String displayAddIngredientForm(Model model){
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "ingredients/create";
    }

    @PostMapping("create")
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            return "ingredients/create";
        }
        ingredientRepository.save(newIngredient);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteIngredientForm(Model model){
        model.addAttribute("title", "Delete Ingredient");
        return "ingredients/delete";
    }

    @PostMapping("delete")
    public String processDeleteIngredientForm(@RequestParam(required = false) int[] ingredientId){
        if(ingredientId != null){
            for(int id : ingredientId){
                ingredientRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("view/{ingredientId}")
    public String ViewAllIngredients(Model model, @PathVariable int ingredientId){
        Optional<Ingredient>optIngredient = ingredientRepository.findById(ingredientId);
        if (optIngredient.isPresent()){
            Ingredient ingredient = (Ingredient) optIngredient.get();
            model.addAttribute("quantity", ingredient.getQuantity());
            model.addAttribute("measurement", ingredient.getMeasurement());
            model.addAttribute("ingredients", ingredient);
            RecipeDTO recipeDTO = new RecipeDTO();
            model.addAttribute("recipeDTO", recipeDTO);
            model.addAttribute("recipes", recipeRepository.findAll());
            return "ingredients/view";
        } else {
            model.addAttribute("title", "Invalid Ingredient ID: " + ingredientId);
            return "redirect:";
        }
    }
}
