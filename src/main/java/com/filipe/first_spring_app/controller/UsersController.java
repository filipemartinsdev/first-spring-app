package com.filipe.first_spring_app.controller;

import com.filipe.first_spring_app.model.User;
import com.filipe.first_spring_app.service.UserService;
import org.apache.coyote.Response;
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
                body(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> usersGet(@PathVariable("id") long id){
        User user = userService.get(id);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(user);
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
        User created = userService.create(user);

        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(created);
    }

    @PostMapping("/createAll")
    public ResponseEntity<List<User>> usersCreateAllPost(@RequestBody List<User> users){
        List<User> createdList = userService.createAll(users);
        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdList);
    }
}
