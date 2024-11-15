package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable("id") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit-User";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
