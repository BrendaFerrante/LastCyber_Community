package Cyber_Community;

/*
*  Handle the mian page
*/


import Cyber_Community.entities.Blog;
import Cyber_Community.entities.ClubHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Transactional
public class CyberController {
    @Autowired
    ClubHolder clubHolder;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/logged")
    public String loggedUser (){return "index2";}

    @GetMapping("/logged/club")
    public String logClubPage (Model model){
        model.addAttribute("silent",true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "LoggedIndexClub_template";
    }

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
