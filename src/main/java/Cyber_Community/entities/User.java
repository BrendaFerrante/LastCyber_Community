package Cyber_Community.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id_User= -1;

    private boolean admin;

    private String nickname; //Unique
    private String email;
    private String password;
    private Date birth;
    private String biography;

    @Override
    public String toString() {
        return "User [id:" + id_User + ", nickname:" + nickname + ", email:" + email + ", admin:" + admin + ", birthday:" + birth + ", biography:" + biography+"]" ;
    }

    public void setId(long i){
        this.id_User = i;
    }

    public String getNickname (){
        return this.nickname;
    }

}