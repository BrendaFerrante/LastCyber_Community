package Cyber_Community.Club;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Club {
    private String name;
    private String description;
    private String admin;
    private String contact;
    private int actualNumMember;


    public void add(){
        this.actualNumMember++;
    }

}
