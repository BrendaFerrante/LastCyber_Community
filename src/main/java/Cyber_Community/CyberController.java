package Cyber_Community;

/*
*  Handle the mian page
*/


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CyberController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError","Incorrect username o password");
        return "index";
    }
    @GetMapping("/club")
    public String club(Model model) {

        return "IndexClub_template";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "index";
    }

}
