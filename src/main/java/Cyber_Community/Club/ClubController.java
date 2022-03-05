package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/")
    public String club(Model model) {
        model.addAttribute("anuncios", clubRepository.findAll());
        return "Club_template";
    }


}
