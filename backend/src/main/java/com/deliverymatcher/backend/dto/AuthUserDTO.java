package com.deliverymatcher.backend.dto;

public record AuthUserDTO(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
