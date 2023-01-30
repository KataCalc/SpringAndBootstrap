package ru.kata.SpringAndBootstrap.service;




import ru.kata.SpringAndBootstrap.model.User;

import java.util.List;


    public interface UserService {
        List<User> findAll();

        User findById(int id);

        User findByEmail(String email);

        User getUserByUsername(String username);

        void save(User user);

        void update(Integer id,User user);

        void deleteById(int id);

        User passwordCoder(User user);

    }


