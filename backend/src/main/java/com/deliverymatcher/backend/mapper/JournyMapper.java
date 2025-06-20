package com.deliverymatcher.backend.mapper;

import com.deliverymatcher.backend.dto.MappedJournyDTO;
import com.deliverymatcher.backend.model.Journy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournyMapper {
    Journy toEntity(MappedJournyDTO mappedJournyDTO);
    MappedJournyDTO toDTO(Journy journy);
}
