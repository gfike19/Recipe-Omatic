package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Ingredient;
import org.launchcode.RecipeOmatic.Recipe;
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

    @GetMapping
    public String displayAllIngredients(Model model) {
        model.addAttribute("title", "All Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    @GetMapping("add")
    public String displayAddIngredientForm(Model model){
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "ingredients/add";
    }

    @PostMapping("add")
    public String processAddIngredientForm(@ModelAttribute Ingredient newIngredient, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            return "ingredients/add";
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

            }
        }
        return "redirect:";
    }

    @GetMapping("view/{ingredientId}")
    public String ViewAllIngredients(Model model, @PathVariable int ingredientId){
        Optional optIngredient = ingredientRepository.findById(ingredientId);
        if (optIngredient.isPresent()){
            Ingredient ingredient = (Ingredient) optIngredient.get();
            model.addAttribute("ingredient", ingredient);
            return "ingredients/view";
        } else {
            return "redirect:../";
        }
    }
}
