package ru.kata.SpringAndBootstrap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.SpringAndBootstrap.model.User;
import ru.kata.SpringAndBootstrap.service.RoleService;
import ru.kata.SpringAndBootstrap.service.UserService;


import java.security.Principal;


@Controller
@RequestMapping("/")
public class AdminController {

    private final UserService usersService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model, Principal principal) {
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("admin", usersService.getUserByUsername(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("rolesAdd", roleService.getRoleList());
        return "admin_page";
    }

    @PostMapping("/admin")
    public String createUser(@ModelAttribute("user") User user) {
        usersService.save(user);
        return "redirect:/admin";
    }

    @PatchMapping(value = "/admin/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Integer id) {
        usersService.update(id, user);
        return "redirect:/admin";
    }


    @DeleteMapping("admin/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        usersService.deleteById(id);
        return "redirect:/admin";
    }


}