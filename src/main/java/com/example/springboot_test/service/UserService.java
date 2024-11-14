package com.example.springboot_test.service;

import com.example.springboot_test.model.AppUser;
import com.example.springboot_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    // Utilisez passwordEncoder pour hasher les mots de passe
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepository.save(appUser);
    }
}
