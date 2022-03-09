package Cyber_Community;

/*
*  Handle the mian page
*/


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Transactional
public class CyberController {
    @GetMapping("/")
    public String root() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "Login.html";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp.html";
    }

    @GetMapping("/profile")
    public String profile(){
        return "User_template";
    }
}
