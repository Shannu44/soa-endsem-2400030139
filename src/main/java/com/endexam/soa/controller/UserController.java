
package com.endexam.soa.controller;

import com.endexam.soa.dto.UserRequest;
import com.endexam.soa.entity.User;
import com.endexam.soa.repository.UserRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return repo.save(user);
    }

   
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(
            @PathVariable String username) {

        return repo.findByUsername(username)
                .<ResponseEntity<?>>map(user ->
                        ResponseEntity.ok(
                                new UserResponse(
                                        user.getId(),
                                        user.getUsername(),
                                        user.getName(),
                                        user.getEmail()
                                )
                        )
                )
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("User not found with username: " + username)
                );
    }

    public record UserResponse(
            Long id,
            String username,
            String name,
            String email
    ) {}
}
