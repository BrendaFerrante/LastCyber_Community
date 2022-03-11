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
    public String root(Model model) {
        model.addAttribute("notlogged",true);
        model.addAttribute("logged",false);
        model.addAttribute("admin",false);
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
        model.addAttribute("logged",true);
        model.addAttribute("not logged",false);
        model.addAttribute("admin",false);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "IndexClub_template";
    }

    @GetMapping("/logged/admin")
    public String loggedAdmin(Model model) {
        model.addAttribute("logged",true);
        model.addAttribute("not logged",false);
        model.addAttribute("admin",true);
        return "indexAdmin";
    }

    @GetMapping("/logged/admin/club")
    public String logAdminClub(Model model) {
        model.addAttribute("logged",true);
        model.addAttribute("not logged",false);
        model.addAttribute("admin",true);
        return "IndexClub_template";
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
    @GetMapping("/editBlog")
    public String editBlog(){
        return "EditBlog.html";
    }


    @GetMapping("/upUser")
    public String upUser(){return "EditUser.html";}

}
