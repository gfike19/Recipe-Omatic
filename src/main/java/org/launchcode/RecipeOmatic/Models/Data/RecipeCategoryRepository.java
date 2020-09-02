package org.launchcode.RecipeOmatic.Models.Data;

import org.launchcode.RecipeOmatic.Models.RecipeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RecipeCategoryRepository extends CrudRepository <RecipeCategory,Integer> {
}
