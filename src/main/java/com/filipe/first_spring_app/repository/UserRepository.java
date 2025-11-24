package com.filipe.first_spring_app.repository;


import com.filipe.first_spring_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//                                                   <Class, ID>
public interface UserRepository extends JpaRepository<User, Long>{
    User findByName(String name);
}
