package ru.kata.SpringAndBootstrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.SpringAndBootstrap.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


    @Query("select r from Role r where r.userRole=:userRole")
    Role getRole(String userRole);

}

