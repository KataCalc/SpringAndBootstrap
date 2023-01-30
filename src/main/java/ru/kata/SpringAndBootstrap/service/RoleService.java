package ru.kata.SpringAndBootstrap.service;


import ru.kata.SpringAndBootstrap.model.Role;


import java.util.List;

public interface RoleService {


    List<Role> getRoleList();

    void saveRole(Role roleAdmin);


}
