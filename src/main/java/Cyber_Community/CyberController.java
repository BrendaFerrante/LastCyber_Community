package Cyber_Community;

/*
 *  Handle the main page
 */


import Cyber_Community.entities.Blog;
import Cyber_Community.entities.ClubHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Transactional
public class CyberController {
    @Autowired
    ClubHolder clubHolder;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/lmau")
    public String lmau(){return "Lmau_template";}
    @GetMapping("/logged/lmau")
    public String lmauLog(){return "LmauLog_template";}
    @GetMapping("/logged/admin/lmau")
    public String lmauLogAd(){return "LmauLogAd_template";}

    //Once the person is logged in the website

    @GetMapping("/logged/club")
    public String logClubPage (Model model){
        model.addAttribute("silent",true);
        model.addAttribute("admin",true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "LoggedIndexClub_template";
    }

    @GetMapping("/logged/admin")
    public String loggedAdmin() {return "indexAdmin";}

    @GetMapping("/logged/admin/club")
    public String logAdminClub() {
        return "LoggedAdminClub_template";
    }


    @GetMapping("/login")
    public String login() {
        return "Login.html";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp.html";
    }


    @GetMapping("/edit")
    public String putClub(Model model){
        return "EditClub.html";
    }

    @GetMapping("/addBlog")
    public String addBlog(Model model){
        return "AddBlog.html";
    }


}
