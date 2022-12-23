package com.kvnbg.api.controller;

import com.kvnbg.api.controller.mappers.UserMapper;
import com.kvnbg.api.controller.records.UserCreateRecord;
import com.kvnbg.api.controller.records.UserUpdateRecord;
import com.kvnbg.api.exception.UserNotFoundException;
import com.kvnbg.api.model.User;
import com.kvnbg.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    private final UserRepository repository;

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UserCreateRecord userCreateRecord) {
        User userToSave = userMapper.toModel(userCreateRecord);
        return ResponseEntity.ok(repository.save(userToSave));
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
