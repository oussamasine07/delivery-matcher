package com.deliverymatcher.backend.mapper;

import com.deliverymatcher.backend.model.Pack;
import com.deliverymatcher.backend.dto.MappedPackageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackMapper {
    Pack toEntity(MappedPackageDTO mappedPackageDTO);
    MappedPackageDTO toDTO(Pack pack);
}
