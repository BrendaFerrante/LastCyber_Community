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
    private User admin;

    @Autowired
    BlogHolder blogHolder;
    @Autowired
    BlogHolder userHolder;

    public Club(String name,String description,User admin) {
        this.name = name;
        this.description=description;
        this.admin=admin;
    }

}
