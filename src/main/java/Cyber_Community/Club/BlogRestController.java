package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogRestController {
    @Autowired
    BlogHolder blogs;
}
