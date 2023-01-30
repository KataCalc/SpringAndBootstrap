package ru.kata.SpringAndBootstrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.SpringAndBootstrap.model.User;


import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u join fetch u.roles where u.email = :email")
    Optional<User> findByEmail(String email);


    @Query("select u from User u join fetch u.roles where u.username = :username")
    User findByUsername(String username);
}
