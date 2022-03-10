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
   // private Date birthday;
    private String biography;

    public User(String nickname,String email,String password, String biography, Boolean admin){
        this.nickname=nickname;
        this.email=email;
        this.password=password;
        this.biography=biography;
       // this.birthday = birthday;
        this.admin=admin;
        //this.id_User=id_User;
    }
    @Override
    public String toString() {
        return "User [nickname:" + nickname + ", email:" + email + ", admin:" + admin + ", biography:" + biography+"]" ;
    }

    public void setId(long i){
        this.id_User = i;
    }

    public String getNickname (){
        return this.nickname;
    }

}
