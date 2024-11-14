package org.example.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivacyController {
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Ceci est un endpoint public accessible sans authentification.";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "Ceci est un endpoint privé qui nécessite une authentification.";
    }
}