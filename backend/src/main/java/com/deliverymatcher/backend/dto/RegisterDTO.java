package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.validation.IsEmailAlreadyExists;
import com.deliverymatcher.backend.validation.IsPasswordConfirmed;
import com.deliverymatcher.backend.validation.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@IsPasswordConfirmed
@IsEmailAlreadyExists
public record RegisterDTO (
    @NotBlank(message = "first name is required")
    String first_name,

    @NotBlank(message = "last name is required")
    String last_name,

    @NotBlank(message = "email is required")
    @Email(message = "make sure you put a valid email")
    String email,

    @NotBlank(message = "password is required")
    @Size(min = 6 , message = "password should be at least 6 charachters")
    String password,

    @NotBlank(message = "please confirm your password")
    String confirmPassword,

    @NotBlank(message = "please choose account type: Driver or Sender")
    @UserType
    String type

) {
}
