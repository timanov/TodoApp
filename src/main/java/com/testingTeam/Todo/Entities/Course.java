package com.testingTeam.Todo.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<ListTodo> todos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<ListTodo> getTodos() {
        return todos;
    }

    public void setTodos(List<ListTodo> todos) {
        this.todos = todos;
    }

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
