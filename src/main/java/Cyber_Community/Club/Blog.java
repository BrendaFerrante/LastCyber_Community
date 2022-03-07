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

    public void setId(long id){
        this.id_Blog = id;
    }

    public long getId() {
        return id_Blog;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Date getDate() {
        return date;
    }
    public int getnLikes() {
        return nLikes;
    }
    public String getResume() {
        return resume;
    }

}
