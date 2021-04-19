package com.workshop.workshopmongo.controller;

import com.workshop.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria", "maria@gmail.com");
        User lucas = new User("2", "lucas", "lucas@gmail.com");
        List<User> users = new ArrayList<User>(Arrays.asList(lucas, maria));
        return ResponseEntity.ok().body(users);
    }
}
