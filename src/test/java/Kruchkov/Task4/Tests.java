package Kruchkov.Task4;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Tests {
    @Test
    public void insert() throws SQLException {  //

        ApplicationContext context =  SpringApplication.run(Config.class);
        UserService userServiceB =context.getBean(UserService.class);
        UserService userService = userServiceB;

        User user =new User("petrov");
        userService.getUserDAO().insert(user);

        user =new User("kuznezov");
        userService.getUserDAO().insert(user);
        userService.getUserDAO().commit();

        List<User> userList = userService.getUserDAO().findAll();
        for(User userD : userList)
            Assertions.assertTrue((userD.getUsername().equals("petrov") || userD.getUsername().equals("kuznezov")),
                    "Не прошла запись или чтение в/из БД");
    }

    @Test
    public void findById() throws SQLException {
        ApplicationContext context =  SpringApplication.run(Config.class);
        UserService userServiceB =context.getBean(UserService.class);
        UserService userService = userServiceB;

        User user =new User("petrov");
        userService.getUserDAO().insert(user);

        user =new User("kuznezov");
        userService.getUserDAO().insert(user);
        userService.getUserDAO().commit();

        List<User> userList = userService.getUserDAO().findAll();

        for(User userD : userList) {
            user = userService.getUserDAO().findById(userD.getId());
            Assertions.assertEquals(user.getUsername(), userD.getUsername());
        }
    }

    @Test
    public void findAll() throws SQLException {
        ApplicationContext context =  SpringApplication.run(Config.class);
        UserService userServiceB =context.getBean(UserService.class);
        UserService userService = userServiceB;

        User user =new User("petrov");
        userService.getUserDAO().insert(user);

        user =new User("kuznezov");
        userService.getUserDAO().insert(user);
        userService.getUserDAO().commit();

        List<User> userList = userService.getUserDAO().findAll();

        for(User userD : userList)
            Assertions.assertTrue((userD.getUsername().equals("petrov") || userD.getUsername().equals("kuznezov")),
                    "Не прошло чтение всех записей из БД");

    }

    @Test
    public void findByUsername() throws SQLException {
        ApplicationContext context =  SpringApplication.run(Config.class);
        UserService userServiceB =context.getBean(UserService.class);
        UserService userService = userServiceB;

        User user =new User("petrov");
        userService.getUserDAO().insert(user);

        user =new User("kuznezov");
        userService.getUserDAO().insert(user);
        userService.getUserDAO().commit();

        List<User> userList = userService.getUserDAO().findAll();

        for(User userD : userList) {
            user = userService.getUserDAO().findByUsername(userD.getUsername());
            Assertions.assertEquals(user.getUsername(), userD.getUsername());
        }
    }

    @Test
    public void delById() throws SQLException {
        ApplicationContext context =  SpringApplication.run(Config.class);
        UserService userServiceB =context.getBean(UserService.class);
        UserService userService = userServiceB;

        User user =new User("petrov");
        userService.getUserDAO().insert(user);

        user =new User("kuznezov");
        userService.getUserDAO().insert(user);
        userService.getUserDAO().commit();

        List<User> userList = userService.getUserDAO().findAll();

        boolean tryCatch = false;
        for(User userD : userList) {

            userService.getUserDAO().delById(userD.getId());
            userService.getUserDAO().commit();
            try {
                user = userService.getUserDAO().findById(userD.getId());
            }
            catch (Exception ex) {
                tryCatch = true;
            }
            Assertions.assertTrue(tryCatch,"Не работает удаление по id");
        }

    }
    @Test
    public void delByUsername() throws SQLException {
        ApplicationContext context =  SpringApplication.run(Config.class);
        UserService userServiceB =context.getBean(UserService.class);
        UserService userService = userServiceB;

        User user =new User("petrov");
        userService.getUserDAO().insert(user);

        user =new User("kuznezov");
        userService.getUserDAO().insert(user);
        userService.getUserDAO().commit();

        List<User> userList = userService.getUserDAO().findAll();
        boolean tryCatch = false;
        for(User userD : userList) {

            userService.getUserDAO().delByUsername(userD.getUsername());
            userService.getUserDAO().commit();
            try {
                user = userService.getUserDAO().findByUsername(userD.getUsername());
            }
            catch (Exception ex) {
                tryCatch = true;
            }
            Assertions.assertTrue(tryCatch,"Не работает удаление по username");
        }

    }


}
