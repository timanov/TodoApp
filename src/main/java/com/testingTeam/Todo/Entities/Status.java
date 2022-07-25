package com.testingTeam.Todo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String role;

    @OneToMany(mappedBy = "status", cascade = CascadeType.PERSIST)
    private List<ListTodo> todos;

    public void addTodo(ListTodo todo) {

        if (todos == null) {
            todos = new ArrayList<>();
        }
        todos.add(todo);
        todo.setStatus(this);
    }
}
