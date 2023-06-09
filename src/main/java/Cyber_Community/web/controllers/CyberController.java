package Cyber_Community.web.controllers;

/*
 *  Handle the main page
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
        model.addAttribute("notlogged",true);
        model.addAttribute("logged",false);
        model.addAttribute("admin",false);
        return "index";
    }

    @GetMapping("/lmau")
    public String lmau(){return "Lmau_template";}


    @GetMapping("/login")
    public String login() {
        return "Login.html";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp.html";
    }

    @GetMapping("/edit")
    public String putClub(Model model){
        return "EditClub.html";
    }

    @GetMapping("/addBlog")
    public String addBlog(Model model){
        return "AddBlog.html";
    }
    @GetMapping("/editBlog")
    public String editBlog(){
        return "EditBlog.html";
    }


    @GetMapping("/upUser")
    public String upUser(){return "EditUser.html";}

}
