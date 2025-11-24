package com.filipe.first_spring_app.service;

import com.filipe.first_spring_app.model.User;
import com.filipe.first_spring_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> createAll(List<User> userList){
        return userRepository.saveAll(userList);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User find(long id){
        return userRepository.getReferenceById(id);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }

//    public User update(User user){
//        return userRepository.save(user);
//    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public boolean existsById(long id){
        return userRepository.existsById(id);
    }
}
