package Cyber_Community.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    UserHolder UserHolder;

    @GetMapping("/user")
    public String usersList(Model model) {
        model.addAttribute("users", UserHolder.getUsers());
        return "UserList_template";
    }

    @GetMapping("/user/{id}")
    public String getUser(Model model,  long id) {
        User u = UserHolder.getUser(id-1);
        model.addAttribute("user", UserHolder.getUser(id));
        return "User_template";
    }

    @PostMapping("/user/new")
    public String createUser(Model model, long id, User newUser) {
        UserHolder.add(newUser);
        model.addAttribute("user", UserHolder.getUser(id));
        return "User_template";
    }

    @PutMapping("/user/{id}")
    public String updateUser(Model model, long id,  User newUser) {
        UserHolder.add(id, newUser);
        model.addAttribute("user",UserHolder.getUser(id));
        return "EditUser_template";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(Model model, long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        UserHolder.removeUser(id);
        return "UserDeleted_template";
    }




}
