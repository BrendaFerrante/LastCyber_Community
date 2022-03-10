package Cyber_Community.web.controllers;

import Cyber_Community.entities.User;
import Cyber_Community.entities.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserHolder UserHolder;

    @GetMapping("/")
    public String usersList(Model model) {
        model.addAttribute("users", UserHolder.getUsers());
        return "UserList_template";
    }

    @GetMapping("/logged/{id}")
    public String getUser(Model model, @PathVariable long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        return "User_template";
    }

    @PostMapping("/new")
    public String createUser(User newUser) {
        UserHolder.add(newUser);
        return "UserSaved";
    }

    @PutMapping("/{id}")
    public String updateUser(Model model, long id,  User newUser) {
        UserHolder.add(id, newUser);
        model.addAttribute("user",UserHolder.getUser(id));
        return "EditUser_template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(Model model, long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        UserHolder.removeUser(id);
        return "UserDeleted_template";
    }

}
