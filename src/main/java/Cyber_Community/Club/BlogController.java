package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    BlogHolder blogHolder;

    @PostMapping("/blog/new") //Add a new blog
    public String newBlog(Model model, Blog blog) {
        blogHolder.add(blog);
        model.addAttribute("blog", blog);
        return "AddBlog";
    }

    @GetMapping("/blog/{id}") //View one blog
    public String viewBlog(Model model, @PathVariable int id) {
        Blog b = blogHolder.getBlog(id - 1);
        model.addAttribute("blog", blogHolder.getBlog(id));
        return "Blog_template";
    }

    @DeleteMapping("/blog/delete/{id}") //Delete one blog
    public String deleteBlog(@PathVariable long id){
        blogHolder.remove(id);
        return "Club_template"; //Go back
    }
    @PutMapping("/blog/update/{id}") //Update one blog
    public String updateBlog(@PathVariable long id, Model model, Blog upBlog){
        blogHolder.add(id, upBlog);
        model.addAttribute("blog", blogHolder.getBlog(id));
        return "AddBlog";
    }
}
