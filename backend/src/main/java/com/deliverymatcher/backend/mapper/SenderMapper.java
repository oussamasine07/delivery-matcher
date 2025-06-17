package com.deliverymatcher.backend.mapper;

import com.deliverymatcher.backend.dto.AuthUserDTO;
import com.deliverymatcher.backend.model.Sender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SenderMapper {
    Sender toEntity(AuthUserDTO authUserDTO);
    AuthUserDTO toDTO(Sender sender);
}
