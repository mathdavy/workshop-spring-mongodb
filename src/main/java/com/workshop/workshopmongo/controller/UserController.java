package com.workshop.workshopmongo.controller;

import com.workshop.workshopmongo.dto.UserDto;
import com.workshop.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDto user) {
        UserDto userDto = userService.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> insertUser(@PathVariable String id, @RequestBody UserDto user) {
        user.setId(id);
        UserDto userDto = userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }
}
