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
    public ResponseEntity<UUID> createRegistration(@RequestBody Registration registrationData) {
        Registration savedRegistrationData = registrationRepository.save(registrationData);
        UUID userId = savedRegistrationData.getId();
        return ResponseEntity.ok().body(userId);
    }

    @GetMapping("/registrations")
    List<Registration> getAllRegistrationData() {
        return registrationRepository.findAll();
    }
}