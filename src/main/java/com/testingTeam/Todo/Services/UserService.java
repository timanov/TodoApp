package com.testingTeam.Todo.Services;

import com.testingTeam.Todo.Entities.User;

public interface UserService {

    public void addUser(User user);

    public User getUser(String name);

    public User updateUser(User user);

    public User deleteUser(String name);

    public User getResponseBean(User user);

    User findByUsername(String login);


}
