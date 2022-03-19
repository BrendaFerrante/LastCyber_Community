package Cyber_Community.api.controllers;

import Cyber_Community.entities.User;
import Cyber_Community.entities.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/api")
@RestController
public class UserRestController {
    @Autowired
    UserHolder userHolder;
    @GetMapping("/users")
    public Collection<User> getUsers() {
        return userHolder.getUsers();
    }

    @GetMapping("/logged/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userHolder.getUser(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        userHolder.add(user);
        return user;
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User newUser) {
        User oldUser = userHolder.getUser(id);
        if (oldUser != null) {
            userHolder.changeUser(id,newUser);
            /*newUser.setId(id);
            users.put(id, newUser);*/
            return new ResponseEntity<>(oldUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {

        User user = userHolder.removeUser(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
