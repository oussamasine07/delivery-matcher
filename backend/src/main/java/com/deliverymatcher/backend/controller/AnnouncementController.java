package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.dto.AnnouncementDTO;
import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.service.AnnouncementService;
import com.deliverymatcher.backend.service.DriverService;
import com.deliverymatcher.backend.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final JwtService jwtService;
    private final DriverService driverService;

    public AnnouncementController (
            final AnnouncementService announcementService,
            final JwtService jwtService,
            final DriverService driverService
    ) {
        this.announcementService = announcementService;
        this.jwtService = jwtService;
        this.driverService = driverService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAnnouncement (@Valid @RequestBody AnnouncementDTO announcementDTO, @RequestHeader("Authorization") String headerToken ) {

        Announcement announcement = new Announcement();

        announcement.setName( announcementDTO.name() );
        announcement.setMaxDimentions( announcementDTO.max_dimentions() );
        announcement.setCapacity( announcementDTO.capacity() );
        announcement.setGoodsType( announcementDTO.goods_type() );

        String token = headerToken.substring(7);

        Claims claims = jwtService.extractAllClaims(token);
        Long driverId = Long.parseLong(claims.get("id").toString());

        Driver driver = driverService.findById( driverId );
        announcement.setDriver( driver );

        return announcementService.create( announcement );
    }

}
