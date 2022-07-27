package com.testingTeam.Todo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private boolean enabled = true;

    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade  = CascadeType.ALL)
    @JsonIgnore
    private List<ListTodo> todos;

    public void setTodos(List<ListTodo> todos) {
        this.todos = todos;
    }
    //    public void addRole(Role role){
//        if (roles == null){
//            roles = new ArrayList<>();
//        }
//        roles.add(role);
//    }

    public void addTodo(ListTodo todo) {

        if (todos == null) {
            todos = new ArrayList<>();
        }
        todos.add(todo);
        todo.setUser(this);
    }

}
