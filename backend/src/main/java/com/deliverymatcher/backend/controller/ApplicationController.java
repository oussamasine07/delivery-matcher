package com.deliverymatcher.backend.controller;


import com.deliverymatcher.backend.dto.ApplyAnnouncementDTO;
import com.deliverymatcher.backend.model.*;
import com.deliverymatcher.backend.model.Pack;
import com.deliverymatcher.backend.repository.AnnouncementRepository;
import com.deliverymatcher.backend.repository.SenderRepository;
import com.deliverymatcher.backend.service.ApplicationService;
import com.deliverymatcher.backend.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {

    private final JwtService jwtService;
    private final SenderRepository senderRepository;
    private final ApplicationService applicationService;
    private final AnnouncementRepository announcementRepository;

    public ApplicationController (
            final JwtService jwtService,
            final SenderRepository senderRepository,
            final ApplicationService applicationService,
            final AnnouncementRepository announcementRepository
    ) {
        this.jwtService = jwtService;
        this.senderRepository = senderRepository;
        this.applicationService = applicationService;
        this.announcementRepository = announcementRepository;
    }

    @PostMapping("/apply")
    public ResponseEntity<?> apply (
            @Valid @RequestBody ApplyAnnouncementDTO applyAnnouncementDTO,
            @RequestHeader("Authorization") String headerToken
    ) {

        // get sender
        String token = headerToken.substring(7);
        Claims claims = jwtService.extractAllClaims(token);
        Long senderId = Long.parseLong(claims.get("id").toString());
        Sender sender = senderRepository.findSenderById( senderId );

        Announcement announcement = announcementRepository.findAnnouncementById(applyAnnouncementDTO.announcement_id());

        // make new application instance
        Application application = new Application();
        application.setApplicationDate( applyAnnouncementDTO.application_date() );
        application.setApplicationStatus(ApplicationStatus.STAND_BY);
        application.setSender( sender );
        application.setAnnouncement( announcement );

        // make new package
        Pack pack = new Pack();
        pack.setWidth( applyAnnouncementDTO.width() );
        pack.setHight(applyAnnouncementDTO.hight());
        pack.setWeight(applyAnnouncementDTO.weight());
        pack.setType(applyAnnouncementDTO.type());

        return applicationService.apply(application, pack);

    }

    @GetMapping
    public ResponseEntity<?> getApplications () {
        return applicationService.getAllApplications();
    }

}















