package com.testingTeam.Todo.Repo;

import com.testingTeam.Todo.Entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course, Long> {

}
