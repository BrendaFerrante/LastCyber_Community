package Cyber_Community.Club;

import Cyber_Community.User.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Enzo Cotter on 07/03/2022.
 */
@Service
public class ClubHolder {
    private Map<Long,Club> clubs= new ConcurrentHashMap<>();
    private AtomicLong lastId=new AtomicLong();

    public ClubHolder(){
        User user = new User();
        this.clubs.put(this.lastId.incrementAndGet(),new Club("Test club","Test","Nobody"));
    }

    public void addClub(Club Club){
        Club.setId(lastId.incrementAndGet());
        clubs.put(lastId.longValue(),Club);
    }

    public void deleteClub(Long id){
        clubs.remove(id);
    }

    public void changeClub(Long id,Club Club){
        Club aux=clubs.get(id);
        aux.setDescription(Club.getDescription());
        aux.setAdmin(Club.getAdmin());
        aux.setContact(Club.getContact());
        aux.setName(Club.getName());
    }

    public Collection<Club> getclubs(){
        return this.clubs.values();
    }

    public Club getClub(Long id){
        return this.clubs.get(id);
    }

}
