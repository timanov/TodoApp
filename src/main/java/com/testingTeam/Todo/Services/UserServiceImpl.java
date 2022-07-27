package com.testingTeam.Todo.Services;


import com.testingTeam.Todo.Entities.Role;
import com.testingTeam.Todo.Entities.User;
import com.testingTeam.Todo.Entities.response.AuthenticationBean;
import com.testingTeam.Todo.Repo.RoleRepo;
import com.testingTeam.Todo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
        return userRepo.findByUsername(name);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(String name) {
        return null;
    }

    //@Override
    public User getResponseBean(User user) {
        AuthenticationBean authenticationBean = new AuthenticationBean(1, 0, "", "", "", "");

        //Возвращаем вообще другой объект из других сущностей, из других объектов. Подумать, можно ли вынести в отдельные методы данную логику
        //ПОсмотреть
        //HttpSession session - в методе контроллера

        // информация о моей сессии; HttpSession session;


        //id пользователя
        //в отдельном меттоде
        //username тоже получит ьнужно
        //token положить tokenSessionID
        //в messages тоже вернуть
        //role взять

    }

    @Override
    public User findByUsername(String login) {
        return null;
    }
}
