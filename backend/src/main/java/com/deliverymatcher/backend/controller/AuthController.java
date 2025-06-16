package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.dto.RegisterDTO;
import com.deliverymatcher.backend.model.User;
import com.deliverymatcher.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    private final AuthService authService;

    public AuthController (
            final AuthService authService
    ) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register ( @Valid @RequestBody RegisterDTO registerDTO ) {
        User registeredUser = authService.registerUser(registerDTO);
        return  new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login () {

        return null;
    }

}
