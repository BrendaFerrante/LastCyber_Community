package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/api")
@RestController
public class BlogRestController {
    @Autowired
    BlogHolder blogHolder;

    @PostMapping("/blog/") //Add a blog to the map
    @ResponseStatus(HttpStatus.CREATED)
    public Blog AddBlog(@RequestBody Blog blog){
        blogHolder.add(blog);
        return blog;
    }

    @GetMapping("/club/{numClub}/blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable long id, @RequestParam String numClub) {
        Blog blog = blogHolder.getBlog(id);
        if (blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/club/{numClub}/blog/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable long id,  @RequestParam String numClub){
        Blog blog = blogHolder.remove(id);
        if(blog != null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/club/{numClub}/blog/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable long id, @RequestBody Blog upBlog, @RequestParam String numClub){
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
