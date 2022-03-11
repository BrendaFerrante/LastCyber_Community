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

    private Long idC;
    private Long idB;

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

    @GetMapping(("/delete/{id}")) //delete a club-get id
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


    @GetMapping("/logged/club")
    public String logClubPage(Model model) {
        model.addAttribute("silent", true);
        model.addAttribute("clubs", clubHolder.getclubs());
        return "LoggedIndexClub_template";
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
    @GetMapping("{id}/blog/new") //edit a club-get id
    public String addBlog(Model model, @PathVariable long id) {
        this.idC = id;
        return "/addBlog";
    }
    @PostMapping( "/blog/new") //Add a new blog to the club
    @ResponseStatus(HttpStatus.CREATED)
    public String AddBlog(Model model, Blog blog) {
        clubHolder.getClub(this.idC).addBlog(blog);
        model.addAttribute("message","This blog has been created");
        return "message";
    }


    @GetMapping("/{idC}/blog/{idB}/delete") //Delete one blog
    public String DeleteBlog(Model model, @PathVariable long idC, @PathVariable long idB){
        clubHolder.getClub(idC).removeBlog(idB-1);
        model.addAttribute("message","This blog has been deleted");
        return "message";


    }
    @GetMapping("/{idC}/blog/{idB}/edit") //Delete one blog
    public String EditBlog(Model model, @PathVariable long idC, @PathVariable long idB){
        this.idC=idC;
        this.idB=idB;
        return "/editBlog";


    }

    @PostMapping("/blog/edit") //Update one blog
    public String UpdateBlog(Model model, Blog upBlog){
        Club club=clubHolder.getClub(this.idC);
        clubHolder.getClub(this.idC).changeBlog(this.idB,upBlog);
        model.addAttribute("message","This blog has been edited");
        return "message";
    }

}


