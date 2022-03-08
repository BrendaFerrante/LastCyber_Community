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
    }

    public Blog(String t, String c, String r, String a, Date d){
        this.title = t;
        this.content = c;
        this. resume = r;
        this.author = a;
        this.date = d;
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
    public void setnLikes(int l){
        this.nLikes = l;
    }

    @Override
    public String toString() {
        return "Blog {" + "title='" + title + '\'' + ", content='" + content + '\'' + ", resume='" + resume + '\'' +
                ", author='" + author + '\'' +", date=" + date + ", nLikes=" + nLikes + '}';
    }

}
