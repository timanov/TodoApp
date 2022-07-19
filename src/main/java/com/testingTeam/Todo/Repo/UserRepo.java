package com.testingTeam.Todo.Repo;

import com.testingTeam.Todo.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>{

    User findByUsername(String login);
}
