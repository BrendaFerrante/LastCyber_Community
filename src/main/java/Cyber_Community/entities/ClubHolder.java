package Cyber_Community.entities;

import Cyber_Community.entities.User;
import Cyber_Community.entities.Club;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClubHolder {
    private Map<Long,Club> clubs= new ConcurrentHashMap<>();
    private AtomicLong lastId=new AtomicLong();

    public ClubHolder(){
        User user = new User();
        this.clubs.put(this.lastId.incrementAndGet(),new Club("Test club","Test" + "\n" + "This is a test and a description just to so: " +
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.\n" +
                "\n" +
                "Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,","Nobody","Contact",
                this.lastId.longValue())
        );
    }

    public void addClub(Club club){
        club.setId(lastId.incrementAndGet());
        this.clubs.put(lastId.longValue(),club);
    }

    public void deleteClub(Long id){
        this.clubs.remove(id);
    }

    public void changeClub(Long id,Club club){
        //String a="aa";
        this.clubs.get(id).setName(club.getName());
        //Club aux= this.clubs.get(id+1);
        /*if(club!=null){
            aux.setName("A");
        }*/

    }

    public void changeClub1(Long id,Club club){
        Club aux= this.clubs.get(id);
        aux.setName(club.getName());
        aux.setAdmin(club.getAdmin());
        aux.setBlogs(club.getBlogs());
        aux.setContact(club.getContact());
        aux.setDescription(club.getDescription());
        aux.setMembers(club.getMembers());
    }

    public Collection<Club> getclubs(){
        return this.clubs.values();
    }

    public Club getClub(Long id){
        return this.clubs.get(id);
        //return repository.findByID(id).orElseThrow()-> new Exception("Club not exit"));
    }

    public void addBlog(Blog blog,Long id){
        this.clubs.get(id).addBlog(blog);
    }


}
