package Cyber_Community.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ClubController {
    @Autowired
    ClubHolder clubHolder;

    @GetMapping("/")
    public String club(Model model) {
        model.addAttribute("Clubs", clubHolder.getclubs());
        return "Club_template";
    }
    @PostMapping("/Clubs/")
    @ResponseStatus(HttpStatus.CREATED)
    public Club nuevoClub(@RequestBody Club Club){
        clubHolder.addClub(Club);
        return Club;
    }
    @DeleteMapping(("/Clubs/{id}"))
    public ResponseEntity<Club> deleteClub(@PathVariable long id){
        Club Club=clubHolder.getClub(id);
        if(Club!=null) {
            clubHolder.deleteClub(id);
            return new ResponseEntity<>(Club,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/Clubs/{id}")
    public ResponseEntity<Club> putClub(@PathVariable long id,@RequestBody Club Club){
        Club aux=clubHolder.getClub(id);
        if(Club!=null) {
            clubHolder.changeClub(id,Club);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/club/{id}")
    public ResponseEntity<Club> getClub(@PathVariable long id){
        Club Club=clubHolder.getClub(id);
        if(Club!=null) {
            return new ResponseEntity<>(Club, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
