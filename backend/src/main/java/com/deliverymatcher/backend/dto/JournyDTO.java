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
import java.util.List;

public record JournyDTO (

    @NotBlank(message = "journy name is required")
    String name,

    Long departure_destination,

    Long final_destination,

    List<Long> passed_by_cities


) {
}
