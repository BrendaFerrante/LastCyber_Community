package Cyber_Community.User;

import Cyber_Community.Club.Blog;
import Cyber_Community.Club.Club;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserHolder {
    private Map<Long, User> users= new ConcurrentHashMap<>();
    private AtomicLong lastId_User=new AtomicLong();
    public UserHolder(){
        this.users.put(this.lastId_User.incrementAndGet(),new User());
    }

    public void add(User user) {
        long id = lastId_User.incrementAndGet();
        user.setId(id);
        this.users.put(user.getId_User(), user);
    }
    public void add(long id, User user) {
        this.users.put(id, user);
    }

    public Collection<User> getUsers(){
        return users.values();
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


}