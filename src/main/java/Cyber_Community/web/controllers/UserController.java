package Cyber_Community.web.controllers;

import Cyber_Community.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {
    @Autowired
    Cyber_Community.entities.UserHolder UserHolder;

    @GetMapping("/users")
    public String usersList(Model model) {
        model.addAttribute("users", UserHolder.getUsers());
        return "UserList_template";
    }

    @GetMapping("/logged")
    public String loggedUser (){return "index2";}

    @GetMapping("/logged/user/{id}")
    public String getUser(Model model, @PathVariable long id) {
        User user = UserHolder.getUser(id);
        model.addAttribute("user", user);
        return "User_template";
    }

    @PostMapping("/user/new")
    public String createUser(User newUser,Model model) {
        UserHolder.add(newUser);
        model.addAttribute("message","This user has been created");
        return "message";
    }

    @GetMapping("/user/update/{id}")
    public String updateUser(Model model, long id,  User newUser) {
        UserHolder.add(id, newUser);
        model.addAttribute("user",UserHolder.getUser(id));
        return "User_template";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(Model model, long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        UserHolder.removeUser(id);
        return "UserDeleted_template";
    }

}
