package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class BlogRestController {
    @Autowired
    BlogHolder blogHolder;

    @PostMapping("/new_Blog") //Add a blog to the map
    public ResponseEntity<Blog> create(@RequestBody Blog blog){
        blogHolder.addBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
