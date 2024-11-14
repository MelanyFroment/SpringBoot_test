package com.example.springboot_test.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "app_user", cascade = CascadeType.ALL)
    private Set<Task> tasks;
    private String username;
    private String password;


    @OneToOne(mappedBy = "app_user", cascade = CascadeType.ALL)
    private Roles roles;

    // Getters et setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return roles;
    }

    public void setRole(Roles roles) {
        this.roles = roles;
    }
}
