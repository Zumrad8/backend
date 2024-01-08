package app.repositories;

import app.domain.User;

public interface UserRepository extends CrudRepository<User>{

    User findByEmail(String email);
}
