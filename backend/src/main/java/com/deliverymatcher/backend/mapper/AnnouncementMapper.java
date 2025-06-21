package com.deliverymatcher.backend.mapper;

import com.deliverymatcher.backend.dto.MappedAnnouncmentDTO;
import com.deliverymatcher.backend.model.Announcement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = JournyMapper.class)
public interface AnnouncementMapper {
    Announcement toEntity(MappedAnnouncmentDTO mappedAnnouncmentDTO);
    MappedAnnouncmentDTO toDTO(Announcement announcement);
}
