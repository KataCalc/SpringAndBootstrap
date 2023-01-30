package ru.kata.SpringAndBootstrap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.SpringAndBootstrap.service.UserService;


import java.security.Principal;
@Controller
@RequestMapping()
public class UserController {

    private final UserService usersService;

    @Autowired
    public UserController(UserService usersService) {
        this.usersService = usersService;
    }



    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", usersService.getUserByUsername(principal.getName()));
        return "show_user";
    }
}