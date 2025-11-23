package com.filipe.first_spring_app.repository;


import com.filipe.first_spring_app.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
//import org.springframework.stereotype.Repository;
import org.hibernate.boot.model.naming.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;

// Clase - Tipo de identificador
public interface UserRepository extends JpaRepository<User, Long>{
}
