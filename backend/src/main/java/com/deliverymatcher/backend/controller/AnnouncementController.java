package com.deliverymatcher.backend.controller;

import com.deliverymatcher.backend.dto.AnnouncementDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {

    @PostMapping("/create")
    public ResponseEntity<?> createAnnouncement (@Valid @RequestBody AnnouncementDTO announcementDTO) {
        return null;
    }

}
