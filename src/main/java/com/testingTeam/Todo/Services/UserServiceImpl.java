package com.testingTeam.Todo.Services;


import com.testingTeam.Todo.Entities.Role;
import com.testingTeam.Todo.Entities.User;
import com.testingTeam.Todo.Repo.RoleRepo;
import com.testingTeam.Todo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public void addUser(User user) {

        Role role = roleRepo.findById(1).get();
        System.out.println(role.getName());
        user.setRoles(Arrays.asList(role));

        userRepo.save(user);
    }

    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(String name) {
        return null;
    }

    @Override
    public User findByUsername(String login) {
        return null;
    }
}
