package org.launchcode.RecipeOmatic.Models.Data;

import org.launchcode.RecipeOmatic.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
