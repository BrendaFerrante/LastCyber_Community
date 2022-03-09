package Cyber_Community;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class CyberRestController {

    /*@GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError","Incorrect username o password");
        return "login";
    }

    @GetMapping("/club")
    public String club() {
        return "IndexClub_template";
    }*/


}
