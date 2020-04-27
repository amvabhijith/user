package com.altran.user.controller;

import com.altran.user.model.User;
import com.altran.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 4013707 on 4/16/2020.
 */

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        return ResponseEntity.ok(userService.registration(user));
    }

    @GetMapping("/getUserDetails/{userName}")
    public ResponseEntity<User> getUserDetails(@PathVariable String userName) {
        return ResponseEntity.ok(userService.getUserDetails(userName));
    }
    
}
