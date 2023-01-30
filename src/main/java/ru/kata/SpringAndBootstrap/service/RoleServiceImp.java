package ru.kata.SpringAndBootstrap.service;


import org.springframework.stereotype.Service;
import ru.kata.SpringAndBootstrap.model.Role;
import ru.kata.SpringAndBootstrap.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }


    public Role getRole(String userRole) {
        return roleRepository.getRole(userRole);


    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

}