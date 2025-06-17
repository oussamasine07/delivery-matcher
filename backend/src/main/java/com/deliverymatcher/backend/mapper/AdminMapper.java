package com.deliverymatcher.backend.mapper;

import com.deliverymatcher.backend.dto.AuthUserDTO;
import com.deliverymatcher.backend.model.Admin;
import com.deliverymatcher.backend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(AuthUserDTO authUserDTO);
    AuthUserDTO toDTO(Admin admin);
}
