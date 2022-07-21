package com.testingTeam.Todo.Repo;

import com.testingTeam.Todo.Entities.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepo extends CrudRepository<Status, Long> {
}
