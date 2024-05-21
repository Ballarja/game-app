package com.GameApp.controller;

import com.GameApp.model.Registration;
import com.GameApp.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
public class RegistrationController {
    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/registration")
    public ResponseEntity<UUID> createRegistration(@RequestBody Registration registration) {
        Registration savedRegistration = registrationRepository.save(registration);
        UUID userId = savedRegistration.getId();
        return ResponseEntity.ok().body(userId);
    }

    @GetMapping("/registrations")
    List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }
}