package org.launchcode.RecipeOmatic.Data;

import org.launchcode.RecipeOmatic.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
