package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.dto.LoginDTO;
import com.deliverymatcher.backend.dto.RegisterDTO;
import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.model.Sender;
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
public class AuthController {

    private final AuthService authService;

    public AuthController (
            final AuthService authService
    ) {
        this.authService = authService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> register ( @Valid @RequestBody RegisterDTO registerDTO ) {
        User registeredUser = authService.registerUser(registerDTO);
        return  new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginDTO loginDTO) {

        User user = null;
        switch (loginDTO.type()) {
            case "sender":
                user = new Sender();
                break;
            case "driver":
                user = new Driver();
                break;
        }

        user.setEmail(loginDTO.email());
        user.setPassword(loginDTO.password());


        return authService.loginUser(user);
    }

}
