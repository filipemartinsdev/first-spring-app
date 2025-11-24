package com.filipe.first_spring_app.service;

import com.filipe.first_spring_app.model.Task;
import com.filipe.first_spring_app.model.User;
import org.springframework.stereotype.Service;
import com.filipe.first_spring_app.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public Task create(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public List<Task> getAllByUserId(long userId){
        return taskRepository.findByUserId(userId);
    }

    public Task getById(long id){
        return taskRepository.getReferenceById(id);
    }

    public void deleteById(long id){
        taskRepository.deleteById(id);
    }

    public List<Task> findOfUser1(){
        return taskRepository.findOfUser1();
    }
}
