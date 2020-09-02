package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Models.Data.IngredientRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeCategoryRepository;
import org.launchcode.RecipeOmatic.Models.Data.RecipeRepository;
import org.launchcode.RecipeOmatic.Models.Recipe;
import org.launchcode.RecipeOmatic.Models.RecipeData;
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

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;


    @RequestMapping(value = "")
    public String search(Model model){
        model.addAttribute("columns", columnChoices);
        String checkedValue = "all";
        model.addAttribute("checkedValue", checkedValue);
        return "search";
    }

    @PostMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Recipe> recipes;
        if(searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            recipes = recipeRepository.findAll();
            String checkedValue = searchType + "";
            model.addAttribute("checkedValue", checkedValue);

        }else {
            recipes = RecipeData.findByColumnAndValue(searchType, searchTerm, recipeRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("recipes", recipes);
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("categories", recipeCategoryRepository.findAll());

        return "search";
    }
}
