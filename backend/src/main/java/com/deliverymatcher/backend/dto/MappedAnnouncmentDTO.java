package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.model.Driver;

import java.util.List;

public record MappedAnnouncmentDTO(
        Long id,
        String name,
        Double maxDimentions,
        String goodsType,
        Double capacity,
        Driver driver,
        List<MappedJournyDTO> journies
) {
}
