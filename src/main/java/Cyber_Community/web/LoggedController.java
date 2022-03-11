package Cyber_Community.web;

import Cyber_Community.entities.ClubHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Enzo Cotter on 11/03/2022.
 */
@Controller
@RequestMapping("/logged")
public class LoggedController {
    @Autowired
    ClubHolder clubHolder;

    //Once the person is logged in the website
    @GetMapping("/lmau")
    public String lmauLog(){return "LmauLog_template";}
    @GetMapping("/admin/lmau")
    public String lmauLogAd(){return "LmauLogAd_template";}

    @GetMapping("/club")
    public String logClubPage (Model model){
        model.addAttribute("logged",true);
        model.addAttribute("not logged",false);
        model.addAttribute("admin",false);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "IndexClub_template";
    }

    @GetMapping("/admin")
    public String loggedAdmin(Model model) {
        model.addAttribute("logged",true);
        model.addAttribute("not logged",false);
        model.addAttribute("admin",true);
        return "indexAdmin";
    }

    @GetMapping("/admin/club")
    public String logAdminClub(Model model) {
        model.addAttribute("logged",true);
        model.addAttribute("not logged",false);
        model.addAttribute("admin",true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "IndexClub_template";
    }
}