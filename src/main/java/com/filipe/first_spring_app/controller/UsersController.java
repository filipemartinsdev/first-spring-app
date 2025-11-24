package com.filipe.first_spring_app.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.filipe.first_spring_app.model.User;
import com.filipe.first_spring_app.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> usersGet(){
        return ResponseEntity
                .status(200).
                contentType(MediaType.APPLICATION_JSON).
                body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> usersGet(@PathVariable("id") long id){
        if (!userService.existsById(id)){
            return ResponseEntity
                    .status(404)
                    .build();
        }

        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.find(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> usersDeleteGet(@PathVariable("id") long id){
        userService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("/create")
    public ResponseEntity<User> usersCreatePost(@RequestBody User user){
        User currentUser = userService.findByName(user.getName());
        if (currentUser == null){
            return ResponseEntity
                    .status(400)
                    .build();
        }

        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(hashedPassword);
        User created = userService.create(user);
        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(created);
    }

    @PostMapping("/createAll")
    public ResponseEntity<List<User>> usersCreateAllPost(@RequestBody List<User> users){
        List<User> hashedUsers = users.stream()
                .map(x -> {
                    x.setPassword(BCrypt.withDefaults().hashToString(12, x.getPassword().toCharArray()));
                    return x;
                })
                .toList();
        List<User> createdList = userService.createAll(hashedUsers);
        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdList);
    }
}
