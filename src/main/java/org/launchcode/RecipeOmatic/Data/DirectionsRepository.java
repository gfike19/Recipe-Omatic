package org.launchcode.RecipeOmatic.Data;

import org.launchcode.RecipeOmatic.Directions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DirectionsRepository extends CrudRepository<Directions, Integer> {
}
