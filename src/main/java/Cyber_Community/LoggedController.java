package Cyber_Community;

import Cyber_Community.entities.ClubHolder;
import Cyber_Community.entities.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Enzo Cotter on 10/03/2022.
 */
@RequestMapping("/logged")
@Controller
public class LoggedController {
    @Autowired
    ClubHolder clubHolder;
    UserHolder userHolder;
    /*@GetMapping("/")
    public String loggedUser(Model model){
        model.addAttribute("logged",true);
        model.addAttribute("admin",false);
        return "index2";
    }



    @GetMapping("/admin")
    public String loggedAdmin(Model model) {
        model.addAttribute("logged",true);
        model.addAttribute("admin",true);
        return "indexAdmin";
    }

    @GetMapping("/admin/club")
    public String logAdminClub(Model model) {
        model.addAttribute("admin",true);
        return "LoggedAdminClub_template";
    }*/

}
