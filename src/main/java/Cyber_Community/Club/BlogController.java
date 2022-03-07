package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    BlogHolder blogHolder;

    @GetMapping("/")
    public String getItem (Model model){
        model.addAttribute("blog", blogHolder.getBlog());
        return "Blog_template";
    }

}
