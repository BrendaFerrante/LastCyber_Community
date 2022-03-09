package Cyber_Community.Club;


import Cyber_Community.User.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Club;
    private String name;
    private String description;
    private String contact;
    private List<User> members;
    private String admin;

    private List<Blog> blogs = new ArrayList<>();

    public Club(String name,String description,String admin) {
        Blog blog=new Blog("Blog test","2","1","2");
        this.name = name;
        this.description=description;
        this.admin=admin;
        this.blogs.add(blog);
    }

    public void add(User u){
        this.members.add(u);
    }

    public void setId(long i) {
        this.id_Club = i;
    }

}
