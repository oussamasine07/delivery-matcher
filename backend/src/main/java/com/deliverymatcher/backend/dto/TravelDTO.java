package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.model.JournyStatus;
import com.deliverymatcher.backend.validation.NextDate;
import com.deliverymatcher.backend.validation.NextTime;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record TravelDTO(
        @NotNull(message = "date is required")
        @NextDate
        LocalDate date,

        @NotNull(message = "take off is required")
        @NextTime
        LocalTime take_off,

        @NotNull(message = "take off is required")
        @NextTime
        LocalTime arrived_at,

        @NotNull(message = "required status are : STAND_BY, ON_ROAD, BREAK, ON_STATION, ARRIVED")
        JournyStatus journy_status,

        Long journy_id
) {
}
