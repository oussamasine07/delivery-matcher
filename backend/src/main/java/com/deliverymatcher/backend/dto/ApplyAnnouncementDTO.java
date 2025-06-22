package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.validation.NextTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ApplyAnnouncementDTO (

        @NextTime
        LocalDate application_date,

        @NotNull(message = "width id required")
        @Min(value = 1, message = "width must be at least 1")
        Double width,

        @NotNull(message = "hight id required")
        @Min(value = 1, message = "hight must be at least 1")
        Double hight,

        @NotNull(message = "weight id required")
        @Min(value = 1, message = "weight must be at least 1")
        Double weight,

        @NotBlank(message = "type is required")
        String type,

        Long announcement_id



) {
}
