package Cyber_Community.api.controllers;

import Cyber_Community.entities.BlogHolder;
import Cyber_Community.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/api/club/{num}")
@RestController
public class BlogRestController {
    @Autowired
    BlogHolder blogHolder;

    @PostMapping("/blog/new") //Add a blog to the map
    @ResponseStatus(HttpStatus.CREATED)
    public Blog AddBlog(@RequestBody Blog blog){
        blogHolder.add(blog);
        return blog;
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable long id) {
        Blog blog = blogHolder.getBlog(id);
        if (blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/blog/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable long id){
        Blog blog = blogHolder.remove(id);
        if(blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/blog/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable long id, @RequestBody Blog upBlog){
        Blog blog = blogHolder.getBlog(id);
        if (blog != null){
            upBlog.setId(id);
            blogHolder.add( id, upBlog);
            return new ResponseEntity<>(upBlog, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
