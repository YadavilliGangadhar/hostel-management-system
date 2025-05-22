package com.hostelmanagement.userservice.controller;

import com.hostelmanagement.userservice.dto.LoginRequest;
import com.hostelmanagement.userservice.entity.User;
import com.hostelmanagement.userservice.repository.UserRepository;
import com.hostelmanagement.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
//
//        if (existingUser.isPresent()) {
//            throw new RuntimeException("Username already exists: " + user.getUsername());
//        }
//        if (user.getPassword() == null) {
//            return ResponseEntity.badRequest().body("Password is required");
//        }
//        User savedUser = userService.saveUser(user);
//        return ResponseEntity.ok(savedUser);  // Wrap User inside ResponseEntity
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        boolean isValid = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
//
//        if (isValid) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }

    @GetMapping("/{username}")
    public Optional<User> getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
