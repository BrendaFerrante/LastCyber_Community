package Cyber_Community.Club;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/club")
@Controller
public class ClubController {
    @Autowired
    ClubRepository clubRepository;


    @GetMapping("/")
    public String Club(Model model) {
        model.addAttribute("clubs",clubRepository.findAll());
        return "Club_template";
    }

    @PutMapping("/edit/{id}")
    public String editClub(Model model,Long id){
        Club club=clubRepository.findById(id).get();
        return "";
    }








}
