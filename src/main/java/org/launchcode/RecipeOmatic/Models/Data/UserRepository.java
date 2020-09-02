package org.launchcode.RecipeOmatic.Models.Data;

import org.launchcode.RecipeOmatic.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<EndUser, Integer> {

    EndUser findByUsername(String username);

}
