package com.deliverymatcher.backend.dto;

public record MappedPackageDTO(
        Long id,
        Double width,
        Double hight,
        Double weight,
        String type
) {
}
