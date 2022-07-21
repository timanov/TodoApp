package com.testingTeam.Todo.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;;

    private String role;

    public List<ListTodo> getTodos() {
        return todos;
    }

    public void setTodos(List<ListTodo> todos) {
        this.todos = todos;
    }

    @OneToMany(mappedBy = "status", cascade = CascadeType.PERSIST)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addTodo(ListTodo todo) {

        if (todos == null) {
            todos = new ArrayList<>();
        }
        todos.add(todo);
        todo.setStatus(this);
    }
}
