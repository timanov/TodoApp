package com.testingTeam.Todo.Repo;

import com.testingTeam.Todo.Entities.ListTodo;
import org.springframework.data.repository.CrudRepository;

public interface ListTodoRepo extends CrudRepository<ListTodo, Integer> {
}
