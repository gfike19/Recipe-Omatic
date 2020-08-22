package org.launchcode.RecipeOmatic.Data;

import org.launchcode.RecipeOmatic.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
