package Cyber_Community.web.controllers;

import Cyber_Community.entities.User;
import Cyber_Community.entities.UserHolder;
import Cyber_Community.web.error_handing.exceptions.NickNameExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {
    @Autowired
    UserHolder UserHolder;

    private Long idU;

    @GetMapping("/users")
    public String usersList(Model model) {
        model.addAttribute("users", UserHolder.getUsers());
        return "UserList_template";
    }

    //Initial page once you log in
    @GetMapping("/logged")
    public String loggedUser (){return "index2";}

    //Get user info, for now we have to write the id, it will be able to make it on its own when we start working with databases.
    @GetMapping("/logged/user/{id}")
    public String getUser(Model model, @PathVariable long id) {
        User user = UserHolder.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("id_User", id);
        return "User_template";
    }

    //Create new user
    @PostMapping("/user/new")
    public String createUser(User newUser,Model model) {
        if(UserHolder.equqlNickName(newUser.getNickname())){
            throw new NickNameExistedException();
        }else {
            UserHolder.add(newUser);
            model.addAttribute("message","This user has been created");
            return "message";
        }
    }

    @GetMapping("/user/update/{id}") //edit a user-get id
    public String updUser( @PathVariable long id) {
        this.idU = id;
        return "/upUser";
    }
    //Modify an existing user
    @PostMapping("user/update/user/updateUs")
    public String updateUser(Model model, User newUser) {
        UserHolder.add(this.idU, newUser);
        model.addAttribute("message", "The user has been edited");
        return "message";

    }


    //Delete an existing user
    @GetMapping("/user/delete/{id}")
    public String deleteUser(Model model, @PathVariable long id) {
        model.addAttribute("user", UserHolder.getUser(id));
        UserHolder.removeUser(id);
        return "UserDeleted_template";
    }

}
