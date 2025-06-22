package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.dto.AnnouncementDTO;
import com.deliverymatcher.backend.model.Announcement;
import com.deliverymatcher.backend.model.Driver;
import com.deliverymatcher.backend.model.Journy;
import com.deliverymatcher.backend.service.AnnouncementService;
import com.deliverymatcher.backend.service.DriverService;
import com.deliverymatcher.backend.service.JournyService;
import com.deliverymatcher.backend.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final JwtService jwtService;
    private final DriverService driverService;
    private final JournyService journyService;

    public AnnouncementController (
            final AnnouncementService announcementService,
            final JwtService jwtService,
            final DriverService driverService,
            final JournyService journyService
    ) {
        this.announcementService = announcementService;
        this.jwtService = jwtService;
        this.driverService = driverService;
        this.journyService = journyService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAnnouncements () {
        return announcementService.getAnnouncements();
    }

    @GetMapping("/announcements-by-dirver-id")
    public ResponseEntity<?> fetchAnnouncementsByDriverId(@RequestHeader("Authorization") String headerToken) {
        String token = headerToken.substring(7);

        Claims claims = jwtService.extractAllClaims(token);
        Long driverId = Long.parseLong(claims.get("id").toString());

        return announcementService.fetchAnnouncementsDriverId( driverId );
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

        if (announcementDTO.journy_id() != null ) {
            Journy journy = journyService.getJournyById( announcementDTO.journy_id() );
            announcement.setJourny( journy );
        }

        return announcementService.create( announcement );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAnnouncement (
            @Valid @RequestBody AnnouncementDTO announcementDTO,
            @RequestHeader("Authorization") String headerToken,
            @PathVariable Long id
    ) {
        // get authenticated driver
        String token = headerToken.substring(7);
        Claims claims = jwtService.extractAllClaims(token);
        Long driverId = Long.parseLong(claims.get("id").toString());

        Announcement announcement = new Announcement();

        announcement.setName( announcementDTO.name() );
        announcement.setMaxDimentions( announcementDTO.max_dimentions() );
        announcement.setCapacity( announcementDTO.capacity() );
        announcement.setGoodsType( announcementDTO.goods_type() );

        Driver driver = driverService.findById( driverId );
        announcement.setDriver( driver );

        return announcementService.update( announcement, id, driverId );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnouncement (@PathVariable Long id, @RequestHeader("Authorization") String headerToken) {
        // get authenticated driver
        String token = headerToken.substring(7);
        Claims claims = jwtService.extractAllClaims(token);
        Long driverId = Long.parseLong(claims.get("id").toString());

        return  announcementService.delete( id, driverId);
    }

}
