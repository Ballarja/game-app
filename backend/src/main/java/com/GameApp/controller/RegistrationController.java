package com.GameApp.controller;

import com.GameApp.model.RegistrationModel;
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
    public ResponseEntity<UUID>createRegistration(@RequestBody RegistrationModel registrationModel){
        RegistrationModel savedRegistrationModel = registrationRepository.save(registrationModel);
        UUID userId = savedRegistrationModel.getId();
        return ResponseEntity.ok().body(userId);
    }

    @GetMapping("/registrations")
    List<RegistrationModel> getAllRegistrationModel(){
        return registrationRepository.findAll();
    }
}
