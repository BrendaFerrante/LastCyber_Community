package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    BlogHolder blogHolder;

    /* Club method ??
    @GetMapping("/") //View all blogs
    public String getItem (Model model){
        model.addAttribute("blog", blogHolder.getBlog());
        return "Blog_template";
    }
    */

    @PostMapping("/blog/new") //Add a new blog / Edit an existing blog
    public String newBlog(Model model, Blog blog) {
        blogHolder.add(blog);
        return "EditBlog_template";
    }

    @GetMapping("/anuncio/{num}") //View one blog
    public String viewBlog(Model model, @PathVariable int num) {
        Blog g = blogHolder.getBlog(num - 1);
        model.addAttribute("blog", blogHolder.getBlog());
        return "Blog_template";
    }
}
