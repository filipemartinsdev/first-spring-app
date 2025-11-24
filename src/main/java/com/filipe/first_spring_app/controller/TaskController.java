package com.filipe.first_spring_app.controller;

import com.filipe.first_spring_app.model.Task;
import com.filipe.first_spring_app.model.User;
import com.filipe.first_spring_app.service.TaskService;
import com.filipe.first_spring_app.service.UserService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private UserService userService;
    public TaskController(TaskService taskService, UserService userService){
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> taskGet(@RequestParam(name="userId", defaultValue = "-1") long userId){
        if (userId == -1){
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(taskService.getAll());
        }
        if (!userService.existsById(userId)){
            return ResponseEntity
                    .status(404)
                    .build();
        }
        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(taskService.getAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> taskByIdGet(@PathVariable("id") long id){
        Task found = taskService.getById(id);
        if (found==null){
            return ResponseEntity
                    .status(404)
                    .build();
        }
        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(found);
    }

    @PostMapping("/create")
    public ResponseEntity<Task> taskPost(@RequestBody Task task){
        if(!userService.existsById(task.getUserId())){
            return ResponseEntity
                    .status(400)
                    .build();
        }

        Task created = taskService.create(task);
        return ResponseEntity
                .status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(created);
    }

    @GetMapping("/user1")
    public ResponseEntity<List<Task>> taskUser1Get(){
        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(taskService.findOfUser1());
    }
}
