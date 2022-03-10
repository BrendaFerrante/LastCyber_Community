package Cyber_Community.api.controllers;


import Cyber_Community.entities.User;
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

    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return users.values();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = users.get(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        long id = lastId.incrementAndGet();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User newUser) {

        User oldUser = users.get(id);

        if (oldUser != null) {

            newUser.setId(id);
            users.put(id, newUser);

            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {

        User user = users.remove(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
