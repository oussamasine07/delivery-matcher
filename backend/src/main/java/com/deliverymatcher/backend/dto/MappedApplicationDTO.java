package com.deliverymatcher.backend.dto;

import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.ApplicationStatus;
import com.deliverymatcher.backend.model.Sender;

import java.time.LocalDate;

public record MappedApplicationDTO(

        Long id,
        LocalDate applicationDate,
        ApplicationStatus applicationStatus,
        //Announcement announcement,
        AuthUserDTO sender,
        MappedPackageDTO pack

) {
}
