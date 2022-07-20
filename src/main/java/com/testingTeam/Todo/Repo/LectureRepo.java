package com.testingTeam.Todo.Repo;

import com.testingTeam.Todo.Entities.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepo extends CrudRepository<Lecture, Long> {
}
