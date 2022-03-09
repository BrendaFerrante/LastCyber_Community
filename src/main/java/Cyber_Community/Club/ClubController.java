package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ClubController {
    @Autowired
    ClubHolder clubHolder;

    @GetMapping("/club")
    public String club(Model model) {
        model.addAttribute("silent",true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "IndexClub_template";
    }

    @GetMapping("/club/{id}")
    public String getClub(Model model,@PathVariable long id){
        model.addAttribute("club",clubHolder.getClub(id));
        return "Club_template";
    }

    @PostMapping("/club/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String postClub(Model model,Club club){
        clubHolder.addClub(club);
        return "ClubSaved_template";
    }
    @DeleteMapping(("/club/delete/{id}"))
    public String deleteClub(Model model,@PathVariable long id){
        model.addAttribute("clubs", clubHolder.getclubs());
        clubHolder.deleteClub(id);
        return "ClubDeleted_template";
    }
    @PutMapping("/club/put/{id}")
    public String putClub(Model model,@PathVariable long id,Club club){
        clubHolder.changeClub(id,club);
        return "ClubSaved_template";
    }
}
