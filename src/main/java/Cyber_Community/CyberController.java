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
    public String root(Model model) {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "Login.html";
    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError","Incorrect username o password");
        return "Login.html";
    }


    @GetMapping("/signup")
    public String signUp() {
        return "SignUp.html";
    }


}
