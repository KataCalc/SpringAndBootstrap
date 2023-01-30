package ru.kata.SpringAndBootstrap.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name", unique = true)
    private String userRole;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String userRole) {
        this.userRole = userRole;
    }

    public Role(int id, String userRole, Set<User> users) {
        this.id = id;
        this.userRole = userRole;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return userRole;
    }


    @Override
    public String toString() {
        String role = getUserRole();
        if (role.equals("ROLE_ADMIN")) {
            return "ADMIN";
        } else {
            if (role.equals("ROLE_USER")) {
                return "USER";
            } else {
                return "ADMIN USER";
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getId() == role.getId() && Objects.equals(getUserRole(), role.getUserRole()) && Objects.equals(getUsers(), role.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserRole(), getUsers());
    }
}
 
