package com.deliverymatcher.backend.mapper;


import com.deliverymatcher.backend.dto.MappedAnnouncementAppDTO;
import com.deliverymatcher.backend.model.Announcement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnnouncementAppMapper {
    MappedAnnouncementAppDTO toEntity(Announcement announcement);
    Announcement toDTO(MappedAnnouncementAppDTO mappedAnnouncementAppDTO);
}
