package org.launchcode.RecipeOmatic.Data;

import org.launchcode.RecipeOmatic.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<EndUser, Integer> {

    EndUser findByUsername(String username);

}
