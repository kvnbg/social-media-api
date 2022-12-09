package com.kvnbg.api.controller;

import com.kvnbg.api.controller.dtos.UserUpdateRecord;
import com.kvnbg.api.exception.UserNotFoundException;
import com.kvnbg.api.model.User;
import com.kvnbg.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(repository.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id, @RequestBody UserUpdateRecord userUpdateRecord) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        if (userUpdateRecord.email() != null) {
            userOptional.get().setEmail(userUpdateRecord.email());
        }

        if (userUpdateRecord.password() != null) {
            userOptional.get().setPassword(userUpdateRecord.password());
        }

        return ResponseEntity.ok(repository.save(userOptional.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }

        repository.delete(userOptional.get());

        return ResponseEntity.accepted().build();
    }
}
