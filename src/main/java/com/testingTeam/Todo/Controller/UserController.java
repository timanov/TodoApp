package com.testingTeam.Todo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.testingTeam.Todo.Entities.User;
import com.testingTeam.Todo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
        System.out.println("Add user");
    }

    @GetMapping("/users/{username}")
    public User getUser(HttpSession session,
                        @PathVariable("username") String username) throws JsonProcessingException {

        System.out.println("Return user");
        User user = userService.getUser(username);
        System.out.println(user.getLastName());

        session.getId(); //возвращает сессию

        return user;
        // newResponseEntity(user, HttpStatus.OK)
    }

//    @DeleteMapping(value = "/posts/{id}")
//    public UserController deleteUser(@PathVariable("username") String username) {
//
//    }
}
