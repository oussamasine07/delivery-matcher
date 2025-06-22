package com.deliverymatcher.backend.mapper;


import com.deliverymatcher.backend.dto.MappedApplicationDTO;
import com.deliverymatcher.backend.model.Application;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PackMapper.class, SenderMapper.class, AnnouncementMapper.class})
public interface ApplicationMapper {
    Application toEntity (MappedApplicationDTO mappedApplicationDTO);
    MappedApplicationDTO toDTO(Application application);

}
