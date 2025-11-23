package com.filipe.first_spring_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    public User(){}
}