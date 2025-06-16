package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.RegisterDTO;
import com.deliverymatcher.backend.model.Admin;
import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.model.Sender;
import com.deliverymatcher.backend.model.User;
import com.deliverymatcher.backend.repository.AdminRepository;
import com.deliverymatcher.backend.repository.DriverRepository;
import com.deliverymatcher.backend.repository.SenderRepository;
import com.deliverymatcher.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;
    private final SenderRepository senderRepository;


    public AuthService (
            final UserRepository userRepository,
            final AdminRepository adminRepository,
            final DriverRepository driverRepository,
            final SenderRepository senderRepository
    ) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.driverRepository = driverRepository;
        this.senderRepository = senderRepository;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User registerUser (RegisterDTO registerDTO) {
        User newUser = null;
        switch (registerDTO.type()) {
            case "admin":
                newUser = new Admin();
                break;
            case "sender":
                newUser = new Sender();
                break;
            case "driver":
                newUser = new Driver();
                break;
        }

        newUser.setFirstName(registerDTO.first_name());
        newUser.setLastName(registerDTO.last_name());
        newUser.setEmail(registerDTO.email());
        newUser.setPassword(encoder.encode(registerDTO.password()));

        return userRepository.save(newUser);

    }





}
