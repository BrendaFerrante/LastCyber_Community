package Cyber_Community.Club;


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
    private String admin;
    private String contact;
    private int actualNumMember;

    @Autowired
    BlogHolder blogHolder;
    public Club(String name,String description,String admin) {
        this.name = name;
        this.description=description;
        this.admin=admin;
    }

    public void add(){
        this.actualNumMember++;
    }

}
