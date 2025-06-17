package com.deliverymatcher.backend.service;

import com.deliverymatcher.backend.dto.AuthUserDTO;
import com.deliverymatcher.backend.dto.RegisterDTO;
import com.deliverymatcher.backend.exception.PasswordIncorrectException;
import com.deliverymatcher.backend.mapper.AdminMapper;
import com.deliverymatcher.backend.mapper.DriverMapper;
import com.deliverymatcher.backend.mapper.SenderMapper;
import com.deliverymatcher.backend.model.Admin;
import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.model.Sender;
import com.deliverymatcher.backend.model.User;
import com.deliverymatcher.backend.repository.AdminRepository;
import com.deliverymatcher.backend.repository.DriverRepository;
import com.deliverymatcher.backend.repository.SenderRepository;
import com.deliverymatcher.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final DriverRepository driverRepository;
    private final SenderRepository senderRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AdminMapper adminMapper;
    private final SenderMapper senderMapper;
    private final DriverMapper driverMapper;


    public AuthService (
            final UserRepository userRepository,
            final AdminRepository adminRepository,
            final DriverRepository driverRepository,
            final SenderRepository senderRepository,
            final AuthenticationManager authenticationManager,
            final JwtService jwtService,
            final AdminMapper adminMapper,
            final SenderMapper senderMapper,
            final DriverMapper driverMapper
    ) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.driverRepository = driverRepository;
        this.senderRepository = senderRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.adminMapper = adminMapper;
        this.senderMapper = senderMapper;
        this.driverMapper = driverMapper;
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

    public ResponseEntity<?> loginUser (User user) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(),
                                    user.getPassword()
                            )
                    );

            if (authentication.isAuthenticated()){
                AuthUserDTO authUser = this.getAuthenticatedUser(user.getEmail());
                String token = jwtService.generateJwtToken(authUser);

                Map<String, String> responseSuccess = new HashMap<>();
                responseSuccess.put("token", token);

                return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
            }

            throw  new PasswordIncorrectException("Invalid credentials");
        }
        catch (AuthenticationException e ) {
            throw  new PasswordIncorrectException("Invalid credentials");
        }
    }

    public AuthUserDTO getAuthenticatedUser ( String email ) {
        User authenticatedUser = userRepository.findUserByEmail( email );
        AuthUserDTO authUserDTO = null;
        switch (authenticatedUser.getClass().getSimpleName()) {
            case "Admin":
                authUserDTO = adminMapper.toDTO((Admin) authenticatedUser);
                break;
            case "Sender":
                authUserDTO = senderMapper.toDTO((Sender) authenticatedUser);
                break;
            case "Driver":
                authUserDTO = driverMapper.toDTO((Driver) authenticatedUser);
                break;
        }
        return authUserDTO;
    }




}
