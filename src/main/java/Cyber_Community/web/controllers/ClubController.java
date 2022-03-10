package Cyber_Community.web.controllers;


import Cyber_Community.entities.ClubHolder;
import Cyber_Community.entities.Club;
import Cyber_Community.web.error_handing.exceptons.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/club")
@Controller
public class ClubController {
    @Autowired
    ClubHolder clubHolder;

    @GetMapping("")
    public String club(Model model) {
        model.addAttribute("logged",false);
        model.addAttribute("admin",true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "IndexClub_template";
    }

    @GetMapping("/{id}")
    public String getClub(Model model,@PathVariable long id){
        Club club=clubHolder.getClub(id);
        if(club==null){
            throw new NotFoundException("Club "+ id +" not found");
            //return "error/404";
        }
        model.addAttribute("club",club);
        return "Club_template";
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String postClub(Model model, Club club){
        clubHolder.addClub(club);
        return "ClubSaved_template";
    }

    @GetMapping("/delete")
    public String deleteClub(Model model){
        model.addAttribute("clubs", clubHolder.getclubs());
        return "ClubDelete_template";
    }

    @GetMapping(("/delete/{id}"))
    public String deleteClub(Model model,@PathVariable long id){
        Club club=clubHolder.getClub(id);
        if(club==null){
            throw new NotFoundException("Club "+ id +" not found");
        }
        clubHolder.deleteClub(id);
        return "ClubDeleted_template";
    }
    @PutMapping("/{id}")
    public String putClub(Model model,@PathVariable long id,Club club){
        clubHolder.changeClub(id,club);
        return "ClubSaved_template";
    }
    @GetMapping("/logged/club")
    public String logClubPage (Model model){
        model.addAttribute("silent",true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "LoggedIndexClub_template";
    }
}
