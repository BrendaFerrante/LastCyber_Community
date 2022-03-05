package Cyber_Community.Club;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private long id_Club;

    private String name;
    private String description;
    private String admin;
    private String contact;
    private int actualNumMember;


    public void add(){
        this.actualNumMember++;
    }

}
