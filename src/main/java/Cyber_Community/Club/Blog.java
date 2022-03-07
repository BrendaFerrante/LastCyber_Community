package Cyber_Community.Club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_Blog;

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
