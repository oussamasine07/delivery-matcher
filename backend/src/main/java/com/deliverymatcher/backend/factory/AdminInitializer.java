package com.deliverymatcher.backend.factory;

import com.deliverymatcher.backend.model.Admin;
import com.deliverymatcher.backend.model.User;
import com.deliverymatcher.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {
    @Bean
    CommandLineRunner createAdmin (UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if  (userRepository.findUserByEmail("sine@gmail.com") == null) {
                User newUser = new Admin();

                newUser.setFirstName("oussama");
                newUser.setLastName("sine");
                newUser.setEmail("sine@gmail.com");
                newUser.setPassword(encoder.encode("123456"));

                userRepository.save(newUser);

            } else {
                System.out.println("this user is already exists");
            }
        };
    }
}
