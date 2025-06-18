package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.model.JournyStatus;
import com.deliverymatcher.backend.validation.IsValidJournyStatus;
import com.deliverymatcher.backend.validation.NextDate;
import com.deliverymatcher.backend.validation.NextTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record JournyDTO (
    @NotBlank(message = "date is required")
    @NextDate
    LocalDate date,

    @NotBlank(message = "take off time is required")
    @NextTime
    LocalTime take_off_at,

    @NotBlank(message = "arrived at time is required")
    @NextTime
    LocalTime arrived_at,

    @NotBlank(message = "road to is required")
    City road_to,

    @IsValidJournyStatus
    JournyStatus journyStatus

) {
}
