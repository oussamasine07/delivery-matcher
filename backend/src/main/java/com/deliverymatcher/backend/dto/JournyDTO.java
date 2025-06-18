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

    @NotNull(message = "date is required")
    @NextDate
    LocalDate date,

    @NotNull(message = "take off time is required")
    @NextTime
    LocalTime take_off_at,

    @NotNull(message = "arrived at time is required")
    @NextTime
    LocalTime arrived_at,

    @IsValidJournyStatus
    JournyStatus journyStatus,

    Long road_to



) {
}
