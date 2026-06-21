package com.example.expensetrackerbackendapi.controllers;

import com.example.expensetrackerbackendapi.DTO.ResponseUserDTO;
import com.example.expensetrackerbackendapi.models.User;
import com.example.expensetrackerbackendapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<ResponseUserDTO> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }
    @GetMapping
    public  ResponseEntity<List<ResponseUserDTO>> getAllUsers() {
        List<ResponseUserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
@GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> getUserById(@PathVariable long id) {
     ResponseUserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> updateUser(@PathVariable long id,@Valid @RequestBody User user) {
       return ResponseEntity.ok(userService.updateUser(id, user));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
