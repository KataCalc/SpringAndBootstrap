package ru.kata.SpringAndBootstrap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.SpringAndBootstrap.model.Role;
import ru.kata.SpringAndBootstrap.model.User;
import ru.kata.SpringAndBootstrap.service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDB {

    private final UserServiceImp userService;

    @Autowired
    public InitDB(UserServiceImp userService) {
        this.userService = userService;
    }


    @PostConstruct
    public void addAdminAndUserInDB() {

        Set<Role> adminRole = new HashSet<>();
        adminRole.add(new Role("ROLE_ADMIN"));
        Set<Role> userRole = new HashSet<>();
        userRole.add(new Role("ROLE_USER"));

        userService.save(new User("Oleg",  20, "admin@mail.ru", "123", adminRole));
        userService.save(new User("Arsen",  47, "user@mail.ru", "123", userRole));
    }
}