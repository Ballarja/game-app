package com.GameApp.controller;

import com.GameApp.dto.LoginResponse;
import com.GameApp.model.Login;
import com.GameApp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private LoginService userService;

    @PostMapping("/register")
    public ResponseEntity<UUID> registerUser(@RequestBody Login user) {
        Login registeredUser = userService.registerUser(user);
        return ResponseEntity.ok().body(registeredUser.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login user) {
        Login loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(new LoginResponse(loggedInUser.getId(), "Login successful"));
        }
        return ResponseEntity.status(401).body(new LoginResponse(null, "Invalid email or password"));
    }
}