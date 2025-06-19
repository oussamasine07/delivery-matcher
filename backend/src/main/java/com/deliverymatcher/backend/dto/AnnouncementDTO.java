package com.deliverymatcher.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AnnouncementDTO(

    @NotBlank(message = "announcement name is required")
    String name,

    @NotNull(message = "max dimentions is required")
    double max_dimentions,

    @NotBlank(message = "goods type is required")
    String goods_type,

    @NotNull(message = "capacity is required")
    double capacity,

    Long journy_id

) {
}















