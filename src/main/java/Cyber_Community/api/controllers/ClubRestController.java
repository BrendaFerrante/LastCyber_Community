package Cyber_Community.api.controllers;

import Cyber_Community.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/api")
@RestController
public class ClubRestController {
    @Autowired
    ClubHolder clubHolder;
    @GetMapping("/club")
    public ResponseEntity<Collection<Club>> getClub(){
        Collection<Club> clubs=clubHolder.getclubs();
        if(clubs!=null) {
            return new ResponseEntity<>(clubs, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/club/{id}")
    public ResponseEntity<Club> getClub(@PathVariable long id){
        Club Club=clubHolder.getClub(id);
        if(Club!=null) {
            return new ResponseEntity<>(Club, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/club/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Club postClub(@RequestBody Club Club){
        clubHolder.addClub(Club);
        return Club;
    }
    @DeleteMapping("/club/{id}")
    public ResponseEntity<Club> deleteClub(@PathVariable long id){
        Club Club=clubHolder.getClub(id);
        if(Club!=null) {
            clubHolder.deleteClub(id);
            return new ResponseEntity<>(Club,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/club/{id}")
    public ResponseEntity<Club> putClub(@PathVariable long id,@RequestBody Club Club){
        Club aux=clubHolder.getClub(id);
        if(Club!=null) {
            clubHolder.changeClub1(id,Club);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //BlogRestController
    @GetMapping("/club/{idC}/blog/{idB}") //View one blog
    public ResponseEntity<Blog> getBlog(@PathVariable long idC, @PathVariable long idB) {
        Blog blog = clubHolder.getClub(idC).getBlog(idB);
        if (blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/club/{id}/blog/new") //Add a new blog to the club
    @ResponseStatus(HttpStatus.CREATED)
    public Blog AddBlog(@PathVariable long id,@RequestBody Blog blog){
        clubHolder.getClub(id).addBlog(blog);
        return blog;
    }

    @DeleteMapping("/club/{idC}/blog/{idB}") //Delete one blog
    public ResponseEntity<Blog> deleteBlog(@PathVariable long idC,@PathVariable long idB){
        Blog blog = clubHolder.getClub(idC).removeBlog(idB);
        if(blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/club/{idC}/blog/{idB}") //Update one blog
    public ResponseEntity<Blog> updateBlog(@PathVariable long idC,@PathVariable long idB,@RequestBody Blog upBlog){
        Blog blog = clubHolder.getClub(idC).getBlog(idB);
        if (blog != null){
            clubHolder.getClub(idC).changeBlog1(idB,upBlog);
            return new ResponseEntity<>(upBlog, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
