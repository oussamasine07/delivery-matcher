package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.ApplicationStatus;

import java.time.LocalDate;

public record MappedAnnouncementAppDTO(
        Long id,
        LocalDate applicationDate,
        ApplicationStatus applicationStatus,
        AuthUserDTO sender,
        MappedPackageDTO pack
) {
}
