package com.deliverymatcher.backend.dto;

import java.util.List;

public record AnnouncementDTO(

        String name,

        Long departureDestination,

        Long finalDestination,

        double maxDimentions,

        String goodsType,

        double capacity,

        List<Long> passed_by_cities

) {
}
