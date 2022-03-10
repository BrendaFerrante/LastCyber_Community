package Cyber_Community;

/*
*  Handle the mian page
*/


import Cyber_Community.entities.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Transactional
public class CyberController {
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/logged")
    public String loggedUser (){return "index2";}

    @GetMapping("/logged/club")
    public String logClubPage (){return "LoggedIndexClub_template";}

    @GetMapping("/logged/admin")
    public String loggedAdmin() {return "indexAdmin";}

    @GetMapping("/logged/admin/club")
    public String logAdminClub() {return "LoggedAdminClub_template";}

    @GetMapping("/allusers")
    public String usersList() {return "UserList_template";}

    @GetMapping("/login")
    public String login() {
        return "Login.html";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp.html";
    }

}
