package com.example.springboot_test.service;

import com.example.springboot_test.model.AppUser;
import com.example.springboot_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username);
        System.out.println(appUser.getUsername());
        System.out.println(appUser.getRole().getRole_name());
        if (appUser == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }

        // Vérifier que le rôle n'est pas null
        if (appUser.getRole() == null) {
            throw new IllegalStateException("L'utilisateur n'a pas de rôle attribué");
        }

        // Créer une autorité à partir du nom du rôle de l'utilisateur
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + appUser.getRole().getRole_name().toUpperCase());

        // Retourner un utilisateur avec son nom, mot de passe et rôle sous forme d'autorité
        return new org.springframework.security.core.userdetails.User(
                appUser.getUsername(),
                appUser.getPassword(),
                Collections.singletonList(authority)
        );
    }
}
