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
    public User getResponseBean(User user, HttpSession session) {
        AuthenticationBean authenticationBean = new AuthenticationBean(user.getId(),
                getError(), user.getUsername(), session.getId(), getMessage(), user.getRoles().get(1));




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

        return user;
    }

    @Override
    public User findByUsername(String login) {
        return null;
    }

    @Override
    public void validationUser(User user) {
        String responseMessage;
        int errorCode = 0;


        if (user.getUsername() == null) errorCode = 13;
        else (user.getUsername() != null) errorCode



        //Дальше проверка на логин, если есть, то

        if (errorCode == 0)  responseMessage = "New user have been created";
        else if (errorCode == 100)  { responseMessage = "Username has been authenticated"; errorCode = 0; }
        else if (errorCode == 200)  { responseMessage = "Password will be changed"; errorCode = 0; }
        else if (errorCode == 300)  { responseMessage = "Password has been changed"; errorCode = 0; }
        else if (errorCode == 400)  { responseMessage = "User has been logged out successfully"; errorCode = 0; }
        else if (errorCode == 500)  { responseMessage = "User has been deleted successfully"; errorCode = 0; }



        //Маппить для юзера;

        //Будем вызывать service и вот. Соблюсти код ошибок
        //Switch. Внутри него будет для каждого свича будет отдельная проверка.

    }
}
