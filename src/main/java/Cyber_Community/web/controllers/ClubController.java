package Cyber_Community.web.controllers;


import Cyber_Community.entities.*;
import Cyber_Community.web.error_handing.exceptons.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequestMapping("/club")
@Controller
@Transactional
public class ClubController {
    @Autowired
    ClubHolder clubHolder;
    private Long idC; //Variable to save id of club
    private Long idB; //Variable to save id of blog

    @GetMapping("") //View all clubs
    public String club(Model model) {
        model.addAttribute("logged", false);
        model.addAttribute("admin", true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "IndexClub_template";
    }

    @GetMapping("/{id}")  //View one club
    public String getClub(Model model, @PathVariable long id) {
        Club club = clubHolder.getClub(id);
        if (club == null) {
            throw new NotFoundException("Club " + id + " not found");
        } else {
            model.addAttribute("club", clubHolder.getClub(id));
            model.addAttribute("blog", clubHolder.getClub(id).getBlogs());
            model.addAttribute("idC", id);
        }
        return "Club_template";
    }

    @PostMapping("/new") //Create a club
    @ResponseStatus(HttpStatus.CREATED)
    public String postClub(Model model, Club club) {
        clubHolder.addClub(club);
        model.addAttribute("message", "This club has been created");
        return "message";
    }

    @GetMapping("/delete") //delete a club
    public String deleteClub(Model model) {
        model.addAttribute("clubs", clubHolder.getclubs());
        return "ClubDelete_template";
    }

    @GetMapping("/delete/{id}") //delete a club
    public String deleteClub(Model model, @PathVariable long id) {
        Club club = clubHolder.getClub(id);
        if (club == null) {
            throw new NotFoundException("Club " + id + " not found");
        }
        model.addAttribute("message", "This club has been deleted");
        clubHolder.deleteClub(id);
        return "message";
    }

    @GetMapping("/edit") //edit a club
    public String EditClub(Model model) {
        model.addAttribute("clubs", clubHolder.getclubs());
        return "ClubEdit_template";
    }

    @GetMapping("/edit/{id}") //edit a club-get id
    public String putClub(Model model, @PathVariable long id) {
        this.idC = id;
        return "/edit";
    }

    /*@PostMapping("/EditClub")

    public String editClub(Model model, Club club) {
    @PostMapping("/editClub") //edit a club
    public String editClub(Model model, @RequestBody Club club) {
        clubHolder.changeClub(this.id, club);
        model.addAttribute("message", "This club has been created");
        return "message";
    }*/
    @PostMapping("/EditClub") //Create a club
    @ResponseStatus(HttpStatus.CREATED)
    public String EditClub(Model model, Club club) {
        clubHolder.changeClub(this.idC,club);
        model.addAttribute("message", "This club has been edited");
        return "message";
    }


    //Blog Contoller part
    @GetMapping("/{idC}/blog/{idB}") //View one blog
    public String viewBlog(Model model, @PathVariable long idC, @PathVariable long idB) {
        //If you are the author you can edit or delete the blog
        model.addAttribute("silent", true);
        model.addAttribute("idC", idC);
        model.addAttribute("blog", clubHolder.getClub(idC).getBlog(idB - 1));
        model.addAttribute("club", clubHolder.getClub(idC));
        return "Blog_template";
    }

    @GetMapping("{idC}/blog/new") //create a blog - get id of club
    public String addBlog(@PathVariable long idC) {
        this.idC = idC;
        return "AddBlog.html";
    }
    @PostMapping( "/blog/new") //Add a new blog to the club with id
    @ResponseStatus(HttpStatus.CREATED)
    public String AddBlog(Model model,@RequestBody Blog blog) {
        model.addAttribute("idC", this.idC);
        clubHolder.getClub(this.idC).addBlog(blog);
        return "BlogSaved_template";
    }

    @GetMapping("/{id}/blog/{idB}/delete") //delete blog - get Club id
    public String deleteBlog(@PathVariable long id, @PathVariable long idB){
        this.idC = id;
        this.idB = idB;
        return "DeleteBlog.html";
    }
    @DeleteMapping("/blog/delete") //Delete one blog
    public String DeleteBlog(){
        clubHolder.getClub(this.idC).removeBlog(this.idB-1);
        return "Club_template"; //Go back
    }

    @GetMapping("/{id}/blog/{idB}/put") //update blog - get Club id
    public String putBlog(@PathVariable long id, @PathVariable long idB){
        this.idC = id;
        this.idB = idB;
        return "EditBlog.html";
    }
    @PutMapping("/blog/edit") //Update one blog
    public String UpdateBlog(Model model, @RequestBody Blog upBlog){
        clubHolder.getClub(this.idC).addBlog(this.idB, upBlog);
        model.addAttribute("blog", clubHolder.getClub(this.idC).getBlog(idB));
        model.addAttribute("id",this.idB);
        return "/club/"+this.idC+"/{blog}/"+this.idB; //View blog updated
    }

}


