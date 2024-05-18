package com.GameApp.controller;

import com.GameApp.model.LoginModel;
import com.GameApp.dto.LoginResponse;
import com.GameApp.model.RegistrationModel;
import com.GameApp.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/submit")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        Optional<RegistrationModel> userOptional = registrationRepository.findByEmail(loginModel.getEmail());

        if (userOptional.isPresent()) {
            RegistrationModel user = userOptional.get();
            if (user.getPassword().equals(loginModel.getPassword())) {
                LoginResponse loginResponse = new LoginResponse(user.getId(), "Login successful");
                return ResponseEntity.ok(loginResponse);
            } else {
                return ResponseEntity.status(401).body(new LoginResponse(null, "Invalid password"));
            }
        } else {
            return ResponseEntity.status(404).body(new LoginResponse(null, "User not found"));
        }
    }
}