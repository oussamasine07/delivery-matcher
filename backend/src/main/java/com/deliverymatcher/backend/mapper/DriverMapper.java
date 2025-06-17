package com.deliverymatcher.backend.mapper;

import com.deliverymatcher.backend.dto.AuthUserDTO;
import com.deliverymatcher.backend.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    Driver toEntity(AuthUserDTO authUserDTO);
    AuthUserDTO toDTO(Driver driver);
}
