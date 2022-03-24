package Cyber_Community.entities;

import Cyber_Community.entities.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserHolder {
    private Map<Long, User> users= new ConcurrentHashMap<>();
    private AtomicLong lastId_User=new AtomicLong();

    public UserHolder(){ //Example Users
        this.users.put(this.lastId_User.incrementAndGet(),new User("anonymous","b.fe@al.es","pass","Hello",false,this.lastId_User.longValue()));
        this.users.put(this.lastId_User.incrementAndGet(),new User("Brenda","hello@h.es","pass","Good Morning",true,this.lastId_User.longValue()));
    }

    public void add(User user) {
        user.setId_User(this.lastId_User.incrementAndGet());
        this.users.put(this.lastId_User.longValue(),user);
       /* long id = lastId_User.incrementAndGet();
        user.setId(id);
        this.users.put(user.getId_User(), user);*/
    }
    /*public void add(long id, User user) {
        this.users.put(id, user);
    }*/

    public Collection<User> getUsers(){
        return this.users.values();
    }

    public User getUser(long id){
        return users.get(id);
    }

    public AtomicLong getId() {
        return lastId_User;
    }

    public User removeUser(long id) {
        return users.remove(id);
    }

    /*
    * Future change id of user to nickname of user
     */
    public boolean equqlNickName(String nickName){
        for(User user:this.getUsers()){
            if(user.getNickname().equals(nickName)) {
                return true;
            }
        }
        return false;
    }


    public void changeUser(Long id,User user){
        User oldUer=this.users.get(id);
        oldUer.setPassword(user.getPassword());
        oldUer.setBiography(user.getBiography());
        oldUer.setEmail(user.getEmail());
        oldUer.setNickname(user.getNickname());
    }



}