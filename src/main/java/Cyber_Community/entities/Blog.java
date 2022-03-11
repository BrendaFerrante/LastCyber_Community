package Cyber_Community.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private AtomicLong id_Blog=new AtomicLong();

    private String title;
    private String content;
    private String resume;
    private String author;
    private Date date;

    public Blog(){
    }

    public Blog(String t, String c, String r, String a){
        this.title = t;
        this.content = c;
        this. resume = r;
        this.author = a;
        Date d = new Date();
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Blog {" + "title='" + title + '\'' + ", content='" + content + '\'' + ", resume='" + resume + '\'' +
                ", author='" + author + '\'' +", date=" + date + '}';
    }


}
