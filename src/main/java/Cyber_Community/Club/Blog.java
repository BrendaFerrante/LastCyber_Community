package Cyber_Community.Club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@Data
@AllArgsConstructor


public class Blog {
    private String title;
    private String content;
    private String resume;
    private String author;
    private Date date;
    private int nLikes;

    public Blog(){
        this.nLikes=0;
    }

    public void addLike(){
        this.nLikes++;
    }


      

}
