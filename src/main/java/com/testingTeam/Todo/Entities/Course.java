package com.testingTeam.Todo.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<ListTodo> todos;

    public void addLecture(Lecture lecture) {

        if (lectures == null) {
            lectures = new ArrayList<>();
    }
        lecture.setCourse(this);
        lectures.add(lecture);
    }

    public void addTodo(ListTodo todo) {

        if (todos == null) {
            todos = new ArrayList<>();
        }
        todos.add(todo);
        todo.setCourse(this);
    }
}
