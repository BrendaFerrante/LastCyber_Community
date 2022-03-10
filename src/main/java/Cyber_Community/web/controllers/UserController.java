package Cyber_Community.web.controllers;

import Cyber_Community.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@Controller
public class UserController {
    @Autowired
    Cyber_Community.entities.UserHolder UserHolder;

    /*public UserController(){
        Date date = new Date();
        UserHolder.add(0, new User (0,false,"anonymus","b.fe@al.es","pass",date,"Hello"));
    }*/

    @GetMapping("/user")
    public String usersList(Model model) {
        model.addAttribute("users", UserHolder.getUsers());
        return "UserList_template";
    }

    @GetMapping("/user/{id}")
    public String getUser(Model model, @PathVariable long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        model.addAttribute("id", id);
        return "User_template";
    }

    @PostMapping("/user/new")
    public String createUser(User newUser) {
        UserHolder.add(newUser);
        return "UserSaved";
    }

    @PutMapping("/user/update/{id}")
    public String updateUser(Model model, long id,  User newUser) {
        UserHolder.add(id, newUser);
        model.addAttribute("user",UserHolder.getUser(id));
        return "EditUser_template";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(Model model, long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        UserHolder.removeUser(id);
        return "UserDeleted_template";
    }

}
