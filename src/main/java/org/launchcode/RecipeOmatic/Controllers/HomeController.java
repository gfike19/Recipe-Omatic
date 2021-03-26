package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Models.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeCategoryRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;


    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", "My Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "index";
    }

    @GetMapping(path="/error")
    public String error () {
        return "error";
    }

}
