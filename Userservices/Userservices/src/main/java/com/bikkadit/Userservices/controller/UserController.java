package com.bikkadit.Userservices.controller;


import com.bikkadit.Userservices.model.User;
import com.bikkadit.Userservices.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiU")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveUser = this.userServices.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = this.userServices.getAllUser();
        return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = this.userServices.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
