package com.klu.ecommerce.controller;

import com.klu.ecommerce.entity.User;
import com.klu.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static class SignupRequest {
        public String username;
        public String email;
        public String password;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest request) {
        if (request.username == null || request.email == null || request.password == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }
        try {
            if (userRepository.findByEmail(request.email) != null) {
                return ResponseEntity.badRequest().body("Email already registered");
            }
            User user = new User();
            user.setUsername(request.username);
            user.setEmail(request.email);
            user.setPassword(passwordEncoder.encode(request.password));
            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed");
        }
    }

    public static class LoginRequest {
        public String email;
        public String password;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        if (request.email == null || request.password == null) {
            return ResponseEntity.badRequest().body("Missing email or password");
        }
        try {
            User user = userRepository.findByEmail(request.email);
            if (user == null) {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
            boolean passMatches = passwordEncoder.matches(request.password, user.getPassword());
            if (!passMatches) {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
            // Authentication success - generate token or session here
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }
}
