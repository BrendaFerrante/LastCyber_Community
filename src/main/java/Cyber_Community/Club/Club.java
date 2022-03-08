package Cyber_Community.Club;


import Cyber_Community.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String contact;
    private List<User> members;
    private List<Blog> blogs=new ArrayList<>();
    private String admin;

    public Club(String name,String description,String admin) {
        Date date=new Date();
        Blog blog=new Blog("new bLog","2","1","2",date);
        this.name = name;
        this.description=description;
        this.admin=admin;
        this.blogs.add(blog);
    }

    public void add(User u){
        members.add(u);
    }

}
