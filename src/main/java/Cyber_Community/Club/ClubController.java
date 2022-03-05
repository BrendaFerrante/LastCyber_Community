package Cyber_Community.Club;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/club")
@Controller
public class ClubController {
    /*@Autowired
    private ClubRepository clubRepository;*/

    @GetMapping("/")
    public String tablon(Model model) {
        //model.addAttribute("clubs",clubRepository.);
        return "Club_template";
    }


}
