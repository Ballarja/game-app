package com.GameApp.controller;

import com.GameApp.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Login login) {
        String email = login.getEmail();
        String password = login.getPassword();
        Login loggedInUser = userRepository.findByEmail(email);

        if (loggedInUser != null && loggedInUser.getPassword().equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("userId", loggedInUser.getUserId());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
