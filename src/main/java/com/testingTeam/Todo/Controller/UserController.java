package com.testingTeam.Todo.Controller;

import com.testingTeam.Todo.Entities.User;
import com.testingTeam.Todo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
        System.out.println("Делаем POST запрос");
    }

    @GetMapping("/users/{username}")
    public UserController getUser(@PathVariable("username") String username) {
        userService.getUser(username);
        System.out.println("Делаем GET запрос");

        return this;
    }
}
