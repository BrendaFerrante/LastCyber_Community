package Cyber_Community.web.controllers;

import Cyber_Community.entities.BlogHolder;
import Cyber_Community.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/club/1/blog")
@Controller
public class BlogController {
    @Autowired
    BlogHolder blogHolder;

    @PostMapping("/new") //Add a new blog
    @ResponseStatus(HttpStatus.CREATED)
    public String AddBlog(Model model, Blog blog) {
        blogHolder.add(blog);
        return "SavedBlog_template";
    }

    @GetMapping("/{id}") //View one blog
    public String viewBlog(Model model, @PathVariable long id) {
        model.addAttribute("silent",true);
        model.addAttribute("blog", blogHolder.getBlog(id));
        return "Blog_template";
    }

    @DeleteMapping("/delete/{id}") //Delete one blog
    public String deleteBlog(Model model, @PathVariable long id){
        blogHolder.remove(id);
        return "Club_template"; //Go back
    }

    @PutMapping("/update/{id}") //Update one blog
    public String updateBlog(Model model, Blog upBlog, @PathVariable long id){
        blogHolder.add(id, upBlog);
        model.addAttribute("blog", blogHolder.getBlog(id));
        return "Blog_template";
    }
}
