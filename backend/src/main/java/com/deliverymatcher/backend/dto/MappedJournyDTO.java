package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.model.City;
import com.deliverymatcher.backend.model.Driver;

import java.util.List;

public record MappedJournyDTO(
        Long id,
        String name,
        City departureDestination,
        City finalDestination,
        City[] passedByCities,
        AuthUserDTO driver
) {
}
