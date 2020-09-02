package org.launchcode.RecipeOmatic.Controllers;

import org.launchcode.RecipeOmatic.Models.DTO.RecipeDTO;
import org.launchcode.RecipeOmatic.Models.Data.RecipeCategoryRepository;
import org.launchcode.RecipeOmatic.Models.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("recipeCategories")
public class RecipeCategoryController {
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "recipeCategories/index";
    }

    @GetMapping("create")
    public String renderCreateRecipeCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new RecipeCategory());
        return "recipeCategories/create";
    }

    @PostMapping("create")
    public String processCreateRecipeCategoryForm(@Valid @ModelAttribute RecipeCategory recipeCategory,
                                                 Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            model.addAttribute(new RecipeCategory());
            return "recipeCategories/create";
        }

        recipeCategoryRepository.save(recipeCategory);
        return "redirect:";
    }

    @GetMapping("view/{categoryId}")
    public String displayViewCategory(Model model, @PathVariable int categoryId) {
        Optional<RecipeCategory> optCategory = recipeCategoryRepository.findById(categoryId);
        if (optCategory.isPresent()) {
            RecipeCategory category = (RecipeCategory) optCategory.get();
            model.addAttribute("category", category);
            RecipeDTO recipeDTO = new RecipeDTO();
            model.addAttribute("recipeDTO", recipeDTO);
            return "recipeCategories/view";
        } else {
            model.addAttribute("title", "Invalid category ID: " + categoryId);
            return "redirect:";
        }
    }
}
