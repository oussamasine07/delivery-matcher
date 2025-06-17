package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.validation.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO (
        @NotBlank(message = "email is required")
        @Email(message = "make sure you put a valid email")
        String email,

        @NotBlank(message = "password is required")
        String password,

        @NotBlank(message = "please choose account type: Driver or Sender")
        @UserType
        String type
) {
}
