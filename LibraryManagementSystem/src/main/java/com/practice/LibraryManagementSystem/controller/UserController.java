package com.practice.LibraryManagementSystem.controller;

import com.practice.LibraryManagementSystem.model.User;
import com.practice.LibraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUser(){
        return service.getAllUser();
    }
    @PostMapping("/add")
    public ResponseEntity<String>  addUser(@RequestBody User user){
        return service.addUser(user);
    }


}
