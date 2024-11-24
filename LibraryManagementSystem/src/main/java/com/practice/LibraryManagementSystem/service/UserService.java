package com.practice.LibraryManagementSystem.service;

import com.practice.LibraryManagementSystem.dao.UserDao;
import com.practice.LibraryManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao repo;

    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> addUser(User user) {
        repo.save(user);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

}
