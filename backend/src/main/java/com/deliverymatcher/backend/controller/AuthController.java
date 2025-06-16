package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    @PostMapping("/register")
    public User register () {
        return  null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login () {

        return null;
    }

}
